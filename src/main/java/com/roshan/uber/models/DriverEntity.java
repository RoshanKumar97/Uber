package com.roshan.uber.models;

import com.roshan.uber.enums.DriverStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "drivers")
@NoArgsConstructor
@Builder
@AllArgsConstructor
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

    @OneToOne(mappedBy = "driverEntity", cascade = CascadeType.ALL)
    private CarEntity carEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DriverStatus driverStatus;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ", " +
                "password = " + password + ", " +
                "mobile = " + mobile + ", " +
                "carEntity = " + carEntity + ", " +
                "driverStatus = " + driverStatus + ")";
    }
}
