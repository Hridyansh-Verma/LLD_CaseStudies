package com.project.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private VehicleType vehicleType;
}
