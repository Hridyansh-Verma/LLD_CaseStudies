package com.project.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Gate extends BaseModel{
    private int gateNumber;
    private Operator operator;
    private GateStatus gateStatus;
    private GateType gateType;
}
