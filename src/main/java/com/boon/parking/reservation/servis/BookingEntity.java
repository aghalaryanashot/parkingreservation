package com.boon.parking.reservation.servis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    @Id
    private UUID id;

    @NotNull
    private UUID parkingSpaceId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @NotNull
    private String userName;
}