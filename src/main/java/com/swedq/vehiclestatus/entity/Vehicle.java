package com.swedq.vehiclestatus.entity;

import com.swedq.vehiclestatus.dto.VehicleStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    @Column(name = "registration_number")
    private String registrationNumber;
    private Integer idCustomer;
    @Column(name = "last_update")
    private Date lastUpdate;

    public Vehicle(VehicleStatusDTO vehicleStatusDTO){
        this.id = vehicleStatusDTO.getId();
        lastUpdate = vehicleStatusDTO.getLastUpdate();
    }
}
