package com.roshan.uber.repositories;

import com.roshan.uber.models.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripRepository extends JpaRepository<TripEntity, UUID> {
}
