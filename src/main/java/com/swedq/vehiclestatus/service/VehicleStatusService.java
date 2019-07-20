package com.swedq.vehiclestatus.service;

import com.swedq.vehiclestatus.dto.VehicleStatusDTO;

public interface VehicleStatusService {

    public void keepVehicleOnline(String vehicleId);
    public VehicleStatusDTO getVehicleStatus(String vehicleId);
}
