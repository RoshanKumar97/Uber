package com.roshan.uber.services.impls;

import com.roshan.uber.adaptors.DriverAdaptor;
import com.roshan.uber.dtos.DriverDto;
import com.roshan.uber.exceptions.DuplicateRecordException;
import com.roshan.uber.models.DriverEntity;
import com.roshan.uber.repositories.DriverRepository;
import com.roshan.uber.services.DriverService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<DriverDto> listDrivers() {
        return DriverAdaptor.toDtos(driverRepository.findAll());
    }

    @Override
    public DriverDto getDriver(UUID id) {
        Optional<DriverEntity> driverEntity = driverRepository.findById(id);
        if(!driverEntity.isPresent()){
            throw new EntityNotFoundException("Driver not found with Id: "+ id);
        }
        return DriverAdaptor.toDto(driverEntity.get());
    }

    @Override
    public DriverDto addDriver(DriverDto driverDto) {
        if ((driverRepository.findByMobile(driverDto.getMobile())).isPresent()){
            throw new DuplicateRecordException("Driver already exists with provided mobile: "+ driverDto.getMobile());
        }

        DriverEntity driverEntity = DriverAdaptor.toEntity(driverDto);

        driverEntity = driverRepository.save(driverEntity);

        return DriverAdaptor.toDto(driverEntity);
    }

}
