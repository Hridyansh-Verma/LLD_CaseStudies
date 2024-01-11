package com.project.parkinglot.repositories;

import com.project.parkinglot.Models.Ticket;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long,Ticket> ticketMap= new TreeMap();
    private Long listId=0L;
    public Ticket save(Ticket ticket)
    {
        ticket.setId(++listId);
        ticket.setCreatedAt(new Date());
        ticketMap.put(listId,ticket);
        return ticket;
    }
}
