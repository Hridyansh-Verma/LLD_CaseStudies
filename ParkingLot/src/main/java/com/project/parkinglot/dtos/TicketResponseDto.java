package com.project.parkinglot.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketResponseDto {
    private Long ticketNumber;
    private int spotNumber;
    private String operatorName;
    private String message;
    private ResponseStatus responseStatus;
}
