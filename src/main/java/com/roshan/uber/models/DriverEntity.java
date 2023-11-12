package com.roshan.uber.models;

import com.roshan.uber.enums.DriverStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "drivers")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class DriverEntity {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private  String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @OneToMany(mappedBy = "driverEntity", cascade = CascadeType.ALL)
    private List<TripEntity> tripEntities;

    @OneToOne(mappedBy = "driverEntity", cascade = CascadeType.ALL)
    private CarEntity carEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DriverStatus driverStatus;

}
