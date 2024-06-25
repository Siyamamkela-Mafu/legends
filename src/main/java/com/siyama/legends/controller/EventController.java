package com.siyama.legends.controller;

import com.siyama.legends.dtos.request.EventRequestDto;
import com.siyama.legends.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/event")
public class EventController {
    private final EventService eventService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add an event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404")
    })

    //TODO :: Return an appropriate ResponseDto
    public ResponseEntity<EventRequestDto> addEvent(@RequestBody EventRequestDto eventRequestDto){
        eventService.saveEvent(eventRequestDto);
        return ResponseEntity.ok(eventRequestDto);
    }
}
