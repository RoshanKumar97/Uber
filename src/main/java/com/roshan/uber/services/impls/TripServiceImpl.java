package com.roshan.uber.services.impls;

import com.roshan.uber.adaptors.TripAdaptor;
import com.roshan.uber.dtos.TripDto;
import com.roshan.uber.models.TripEntity;
import com.roshan.uber.repositories.TripRepository;
import com.roshan.uber.services.TripService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    TripRepository tripRepository;

    @Override
    public List<TripDto> listTrips() {
        return TripAdaptor.toDtos(tripRepository.findAll());
    }

    @Override
    public TripDto getTrip(UUID id) {
        Optional<TripEntity> tripEntity = tripRepository.findById(id);
        if(!tripEntity.isPresent()){
            throw new EntityNotFoundException("Trip not found with Id: "+ id);
        }
        return TripAdaptor.toDto(tripEntity.get());
    }

    @Override
    public TripDto addTrip(TripDto tripDto) {

        TripEntity tripEntity = TripAdaptor.toEntity(tripDto);

        tripEntity = tripRepository.save(tripEntity);

        return TripAdaptor.toDto(tripEntity);
    }
}
