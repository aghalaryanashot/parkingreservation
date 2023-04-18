package com.boon.parking.reservation.servis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parking_space")
public class ParkingSpaceEntity {
    @Id
    @NotNull
    private UUID id;

    @NotNull
    @Column(name = "name")
    private String name;


    public ParkingSpaceEntity(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}