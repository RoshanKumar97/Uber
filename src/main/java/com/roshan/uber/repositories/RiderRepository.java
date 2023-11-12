package com.roshan.uber.repositories;

import com.roshan.uber.models.RiderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RiderRepository extends JpaRepository<RiderEntity, UUID> {
    Optional<RiderEntity> findByMobile(String mobile);
}
