package com.swedq.vehiclestatus.controller;

import com.swedq.vehiclestatus.dto.VehicleStatusDTO;
import com.swedq.vehiclestatus.exception.BusinessException;
import com.swedq.vehiclestatus.exception.RestFulException;
import com.swedq.vehiclestatus.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/vehicle/status", headers = "Accept=application/json")
public class VehicleStatusController {

    @Autowired
    VehicleStatusService service;

    @PostMapping("/{vehicleId}")
    ResponseEntity<Void> updateVehicleStatus(@PathVariable String vehicleId){
        try {
            if (StringUtils.isEmpty(vehicleId)) {
                return ResponseEntity.badRequest().build();
            }

            service.keepVehicleOnline(vehicleId);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch(BusinessException be) {
            throw new RestFulException(be.getMessage());
        }
    }

    @GetMapping("/{vehicleId}")
    ResponseEntity<VehicleStatusDTO> getVehicleStatus(@PathVariable String vehicleId){
        try {
            if (StringUtils.isEmpty(vehicleId)) {
                return ResponseEntity.badRequest().build();
            }

            VehicleStatusDTO vehicleStatusDTO = service.getVehicleStatus(vehicleId);

            return ResponseEntity.ok(vehicleStatusDTO);
        }catch(BusinessException be) {
            throw new RestFulException(be.getMessage());
        }
    }
}
