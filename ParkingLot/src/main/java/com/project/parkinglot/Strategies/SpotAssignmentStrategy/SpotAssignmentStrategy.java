package com.project.parkinglot.Strategies.SpotAssignmentStrategy;

import com.project.parkinglot.Exceptions.SpotNotFoundException;
import com.project.parkinglot.Models.Gate;
import com.project.parkinglot.Models.ParkingLot;
import com.project.parkinglot.Models.ParkingSpot;
import com.project.parkinglot.Models.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) throws SpotNotFoundException;
}
