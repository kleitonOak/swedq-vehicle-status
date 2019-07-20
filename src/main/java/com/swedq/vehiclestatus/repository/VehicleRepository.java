package com.swedq.vehiclestatus.repository;

import com.swedq.vehiclestatus.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    public Optional<Vehicle> findByIdCustomer(Integer idCustomer);
}
