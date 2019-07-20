package com.swedq.vehiclestatus.service;

import com.swedq.vehiclestatus.dto.VehicleStatusDTO;
import com.swedq.vehiclestatus.entity.Vehicle;
import com.swedq.vehiclestatus.exception.BusinessException;
import com.swedq.vehiclestatus.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class VehicleStatusServiceImpl implements VehicleStatusService{
    private static final String MESSAGE_VEHICLE_NOT_FOUND = "Vehicle not found";
    @Autowired
    VehicleRepository repository;
    @Override
    public void keepVehicleOnline(String vehicleId) {

        Optional<Vehicle> optionalVehicle = repository.findById(vehicleId);
        if(!optionalVehicle.isPresent()){
           throw new BusinessException(MESSAGE_VEHICLE_NOT_FOUND);
        }

        Vehicle vehicle = optionalVehicle.get();
        vehicle.setLastUpdate(new Date());
        repository.save(vehicle);

    }

    @Override
    public VehicleStatusDTO getVehicleStatus(String vehicleId) {
        Optional<Vehicle> optionalVehicle = repository.findById(vehicleId);
        if(!optionalVehicle.isPresent()){
            throw new BusinessException(MESSAGE_VEHICLE_NOT_FOUND);
        }

        Vehicle vehicle = optionalVehicle.get();
        return new VehicleStatusDTO(vehicle);
    }
}
