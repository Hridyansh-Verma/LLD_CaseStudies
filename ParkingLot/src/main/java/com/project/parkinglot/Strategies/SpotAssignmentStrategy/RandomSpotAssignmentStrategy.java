package com.project.parkinglot.Strategies.SpotAssignmentStrategy;

import com.project.parkinglot.Exceptions.SpotNotFoundException;
import com.project.parkinglot.Models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) throws SpotNotFoundException {
        for (ParkingFloor parkingFloor:parkingLot.getParkingFloorList())
        {
            for(ParkingSpot parkingSpot:parkingFloor.getParkingSpotList())
            {
                if(parkingSpot.getSpotStatus()==SpotStatus.AVAILABLE
                        &&parkingSpot.getSupportedVehicleTypes().contains(vehicleType))
                {
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
