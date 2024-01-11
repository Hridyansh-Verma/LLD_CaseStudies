package com.project.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Bill extends BaseModel{
    private Date exitTime;
    private Ticket ticket;
    private Operator operator;
    private int amount;
    private Gate gate;
}
