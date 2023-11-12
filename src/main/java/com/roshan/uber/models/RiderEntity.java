package com.roshan.uber.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "riders")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class RiderEntity {
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

    @OneToMany(mappedBy = "riderEntity", cascade = CascadeType.ALL)
    private List<TripEntity> tripEntities;
}
