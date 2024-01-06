package com.roshan.uber.services.impls;

import com.roshan.uber.adaptors.RiderAdaptor;
import com.roshan.uber.dtos.RiderDto;
import com.roshan.uber.exceptions.DuplicateRecordException;
import com.roshan.uber.models.RiderEntity;
import com.roshan.uber.repositories.RiderRepository;
import com.roshan.uber.services.RiderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RiderServiceImpl implements RiderService {

    @Autowired
    RiderRepository riderRepository;

    @Override
    public List<RiderDto> listRiders() {
        return RiderAdaptor.toDtos(riderRepository.findAll());
    }

    @Override
    public RiderDto getRider(UUID id) {
        Optional<RiderEntity> riderEntity = riderRepository.findById(id);
        if(!riderEntity.isPresent()){
            throw new EntityNotFoundException("Rider not found with Id: "+ id);
        }
        return RiderAdaptor.toDto(riderEntity.get());
    }

    @Override
    public RiderDto addRider(RiderDto riderDto) {
        if ((riderRepository.findByMobile(riderDto.getMobile())).isPresent()){
            throw new DuplicateRecordException("Rider already exists with provided mobile: "+ riderDto.getMobile());
        }

        RiderEntity riderEntity = RiderAdaptor.toEntity(riderDto);

        riderEntity = riderRepository.save(riderEntity);

        return RiderAdaptor.toDto(riderEntity);
    }

    @Override
    public RiderDto getRiderByMobile(String mobile) {
        if ((riderRepository.findByMobile(mobile)).isEmpty()){
            throw new UsernameNotFoundException("Rider with the given Mobile does not exist: "+ mobile);
        }
        Optional<RiderEntity> riderEntity = riderRepository.findByMobile(mobile);
        return RiderAdaptor.toDto(riderEntity.get());
    }
}
