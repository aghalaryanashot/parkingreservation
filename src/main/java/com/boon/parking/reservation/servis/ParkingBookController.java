package com.boon.parking.reservation.servis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "parking", description = "парковка")
public class ParkingBookController {

    private final ParkingSpaceService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/v1/parking-spaces", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение списка свободных парковочных мест",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Данные получены",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ParkingSpaceEntity.class)))
            })
    public List<ParkingSpaceEntity> getFreeParkingSpaces() {
        log.info("Получение списка свободных парковочных мест");
        return service.getFreeParkingSpaces();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/api/v1/parking-spaces", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Создание нового парковочного места",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Данные получены",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ParkingSpaceEntity.class)))
            })
    public ParkingSpaceEntity saveParkingSpace(@RequestBody ParkingSpaceDto parkingSpaceDto ) {
        log.info("Создание нового парковочного места");
        return service.saveParkingSpace(new ParkingSpaceEntity(parkingSpaceDto.getName()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/api/v1/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Регистрация бронирования парковочного места",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Данные получены",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ParkingSpaceEntity.class)))
            })
    public int registerReservation(@RequestBody ReservationDto dto ) {
        log.info("Регистрация бронирования парковочного места");
        return service.registerReservation(dto);
    }

}
