package com.roshan.uber.models;

import com.roshan.uber.utils.geocode.Response;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "trips")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class TripEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @ManyToOne
    private DriverEntity driverEntity;

    @ManyToOne
    private RiderEntity riderEntity;

    @Column(name = "pickup", columnDefinition = "json")
    @Type(JsonType.class)
    private Response pickup;

    @Column(name = "destination", columnDefinition = "json")
    @Type(JsonType.class)
    private Response destination;
}
