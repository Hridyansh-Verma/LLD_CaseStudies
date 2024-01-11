package com.project.parkinglot.dtos;

import com.project.parkinglot.Models.Gate;
import com.project.parkinglot.Models.Vehicle;
import com.project.parkinglot.Models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketRequestDto {
    private Long gateId;
    private String vehicleNumber;
    private VehicleType vehicleType;
}
