package com.project.parkinglot.services;

import com.project.parkinglot.Exceptions.GateNotFoundException;
import com.project.parkinglot.Exceptions.SpotNotFoundException;
import com.project.parkinglot.Models.*;
import com.project.parkinglot.Strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;
import com.project.parkinglot.repositories.GateRepository;
import com.project.parkinglot.repositories.ParkingLotRepository;
import com.project.parkinglot.repositories.TicketRepository;
import com.project.parkinglot.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    public TicketService(GateRepository gateRepositories,VehicleRepository vehicleRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,TicketRepository ticketRepository,
                        ParkingLotRepository parkingLotRepository)
    {
        this.gateRepository=gateRepositories;
        this.vehicleRepository=vehicleRepository;
        this.spotAssignmentStrategy=spotAssignmentStrategy;
        this.ticketRepository=ticketRepository;
        this.parkingLotRepository=parkingLotRepository;
    }
    public Ticket generateTicket(Long gateId, VehicleType vehicleType, String vehicleNumber) throws GateNotFoundException, SpotNotFoundException {
        Optional<Gate> gateOptional= gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty())
        {
            throw new GateNotFoundException();
        }
        Gate gate= gateOptional.get();
        Vehicle vehicle;
        Optional<Vehicle> vehicleOptional=vehicleRepository.findVehicleByNumber(vehicleNumber);
        if(vehicleOptional.isEmpty())
        {
            vehicle= new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle=vehicleRepository.save(vehicle);
        }
        else
        {
            vehicle=vehicleOptional.get();
        }
        Optional<ParkingSpot> optionalParkingSpot=spotAssignmentStrategy.findSpot(vehicleType,parkingLotRepository.getParkingLotFromGate(gate).get(),gate);
        if(optionalParkingSpot.isEmpty())
        {
            throw new SpotNotFoundException();
        }
        Ticket ticket= new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setParkingSpot(optionalParkingSpot.get());
        return ticketRepository.save(ticket);
    }
}
