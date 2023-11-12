package com.roshan.uber.models;

import com.roshan.uber.utils.geocode.Response;
import jakarta.persistence.*;
import lombok.*;
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

    @Column(name = "pickup")
    private Response pickup;

    @Column(name = "destination")
    private Response destination;
}
