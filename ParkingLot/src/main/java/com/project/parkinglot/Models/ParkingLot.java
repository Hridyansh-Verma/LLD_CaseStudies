package com.project.parkinglot.Models;

import com.project.parkinglot.Models.ParkingFloor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloorList;
    private List<Gate> gateList;
    private int capacity;

}
