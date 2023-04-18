package com.boon.parking.reservation.servis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceEntity, UUID>, JpaSpecificationExecutor<ParkingSpaceEntity> {

    @Query(value = "select * from parking_space WHERE NOT EXISTS(" +
            "  SELECT id FROM booking  WHERE parking_space.id = booking.parking_space_id" +
            " AND booking.start_time <= now() AND booking.end_time >= now())", nativeQuery = true)
    List<ParkingSpaceEntity> getFreeParkingSpaces();
}
