package com.project.parkinglot.Controllers;

import com.project.parkinglot.Exceptions.GateNotFoundException;
import com.project.parkinglot.Exceptions.SpotNotFoundException;
import com.project.parkinglot.Models.Ticket;
import com.project.parkinglot.Models.VehicleType;
import com.project.parkinglot.dtos.ResponseStatus;
import com.project.parkinglot.dtos.TicketRequestDto;
import com.project.parkinglot.dtos.TicketResponseDto;
import com.project.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService)
    {
        this.ticketService=ticketService;
    }
    public TicketResponseDto generateTicket(TicketRequestDto ticketRequestDto){
        Long gateId=ticketRequestDto.getGateId();
        String vehicleNumber=ticketRequestDto.getVehicleNumber();
        VehicleType vehicleType=ticketRequestDto.getVehicleType();
        Ticket ticket = null;
        TicketResponseDto ticketResponseDto= new TicketResponseDto();
        try {
            ticket = ticketService.generateTicket(gateId,vehicleType,vehicleNumber);
            ticketResponseDto.setTicketNumber(ticket.getId());
            ticketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            ticketResponseDto.setOperatorName(ticket.getOperator().getName());
            ticketResponseDto.setSpotNumber(ticket.getParkingSpot().getNumber());
        } catch (GateNotFoundException | SpotNotFoundException e) {
            ticketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            throw new RuntimeException(e);
        }
        return ticketResponseDto;
    }
}
