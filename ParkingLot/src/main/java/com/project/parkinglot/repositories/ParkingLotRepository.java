package com.project.parkinglot.repositories;

import com.project.parkinglot.Models.Gate;
import com.project.parkinglot.Models.ParkingFloor;
import com.project.parkinglot.Models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long,ParkingLot> parkingLotMap= new TreeMap<>();
    public Optional<ParkingLot> getParkingLotFromGate(Gate gate)
    {
        for (ParkingLot parkingLot: parkingLotMap.values()) {
            if (parkingLot.getGateList().contains(gate)) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
