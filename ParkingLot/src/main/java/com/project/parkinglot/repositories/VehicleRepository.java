package com.project.parkinglot.repositories;

import com.project.parkinglot.Models.Vehicle;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {
    private Map<String,Vehicle> vehicleMap= new TreeMap<>();
    private Long listId=0L;
    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
        if(vehicleMap.containsKey(vehicleNumber))
        {
            return Optional.of(vehicleMap.get(vehicleNumber));
        }
        return Optional.empty();
    }
    public Vehicle save(Vehicle vehicle)
    {
        vehicle.setId(++listId);
        vehicle.setCreatedAt(new Date());
        vehicleMap.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
}
