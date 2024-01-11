package com.project.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> parkingSpotList;
    private int floorNumber;
}
