package com.project.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingSpot extends BaseModel{
    private int number;
    private List<VehicleType> supportedVehicleTypes;
    private SpotStatus spotStatus;
    private Vehicle vehicle;
}
