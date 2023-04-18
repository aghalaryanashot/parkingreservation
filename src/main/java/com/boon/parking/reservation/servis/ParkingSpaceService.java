package com.boon.parking.reservation.servis;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParkingSpaceService {
    private final ParkingSpaceRepository parkingSpaceRepository;
    private final BookingRepository bookingRepository;

    public List<ParkingSpaceEntity> getFreeParkingSpaces() {
        return parkingSpaceRepository.getFreeParkingSpaces();
    }

    public ParkingSpaceEntity saveParkingSpace(final ParkingSpaceEntity spaceEntity) {
        return parkingSpaceRepository.save(spaceEntity);
    }

    public int reservation(final ReservationDto dto) {
        var a = bookingRepository.insertBookingIfNotExists(UUID.randomUUID(),dto.getParkingSpaceId(),dto.getStartTime(),
                dto.getEndTime(),dto.getUserName());
        System.out.println(a);
        return a;
    }

}