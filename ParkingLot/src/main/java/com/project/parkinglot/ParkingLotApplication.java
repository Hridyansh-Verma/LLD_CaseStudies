package com.project.parkinglot;

import com.project.parkinglot.Controllers.TicketController;
import com.project.parkinglot.Strategies.SpotAssignmentStrategy.RandomSpotAssignmentStrategy;
import com.project.parkinglot.Strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;
import com.project.parkinglot.repositories.GateRepository;
import com.project.parkinglot.repositories.ParkingLotRepository;
import com.project.parkinglot.repositories.TicketRepository;
import com.project.parkinglot.repositories.VehicleRepository;
import com.project.parkinglot.services.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingLotApplication {

    public static void main(String[] args) {
        GateRepository gateRepository=new GateRepository();
        ParkingLotRepository parkingLotRepository= new ParkingLotRepository();
        TicketRepository ticketRepository= new TicketRepository();
        VehicleRepository vehicleRepository= new VehicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy= new RandomSpotAssignmentStrategy();

        TicketService ticketService= new TicketService(gateRepository,vehicleRepository,spotAssignmentStrategy,
                ticketRepository,parkingLotRepository);
        TicketController ticketController= new TicketController(ticketService);
        System.out.println("App started");
    }

}
