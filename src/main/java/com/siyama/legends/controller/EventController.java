package com.siyama.legends.controller;

import com.siyama.legends.dtos.request.EventRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Events")
@Slf4j
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("api/events")
public class EventController {
    private final EventService eventService;

    @PostMapping(value = "/{organisationId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add an event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "409")
    })

    public ResponseEntity<SaveResponseDto> addEvent(
            @PathVariable("organisationId") String organisationId,
            @Valid @RequestBody EventRequestDto eventRequestDto
    ) {
        log.info(String.format("POST /api/event/%s %s", organisationId, eventRequestDto));
        var response = eventService.saveEvent(eventRequestDto);
        return ResponseEntity.ok(response);
    }
}
