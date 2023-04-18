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
@Tag(name = "parking", description = "паковка")
public class ParkingBookController {

    private final ParkingSpaceService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/api/v1/parking_book", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Получение списка свободных порковок сейчас",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Данные получены",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ParkingSpaceEntity.class)))
            })
    public List<ParkingSpaceEntity> getPrintJobs() {
        log.info("Получение списка свободных порковок сейчас");
        return service.getFreeParkingSpaces();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/api/v1/parking_space_save", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "создать паковочное место",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Данные получены",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ParkingSpaceEntity.class)))
            })
    public ParkingSpaceEntity saveParkingSpace(@RequestBody ParkingSpaceDto parkingSpaceDto ) {
        log.info("создать паковочное место");
        return service.saveParkingSpace(new ParkingSpaceEntity(parkingSpaceDto.getName()));
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/api/v1/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Данные получены",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ParkingSpaceEntity.class)))
            })
    public int reservation(@RequestBody ReservationDto dto ) {
        log.info("зарегистрировот порковочное место");
        return service.reservation(dto);
    }

}
