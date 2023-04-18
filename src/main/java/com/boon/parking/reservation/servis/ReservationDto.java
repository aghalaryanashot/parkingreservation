package com.boon.parking.reservation.servis;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ReservationDto {
    private UUID parkingSpaceId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String userName;
}
