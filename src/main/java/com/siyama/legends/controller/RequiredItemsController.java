package com.siyama.legends.controller;


import com.siyama.legends.dtos.request.RequiredItemRequestDto;
import com.siyama.legends.dtos.response.RequiredItemsBudgetResponseDto;
import com.siyama.legends.service.RequiredItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Required Items")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/required-items")
public class RequiredItemsController {
    private final RequiredItemService requiredItemService;

    @PostMapping(value = "/{eventId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add an item for each event")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "409")
    })
    public ResponseEntity<String> addItem(
            @PathVariable("eventId") String eventId,
            @RequestParam(value = "force", defaultValue = "false") boolean forceSave,
            @RequestBody @Valid RequiredItemRequestDto item
    ) {
        log.info(String.format("POST /api/required-items/:eventId item: [ %s ] ", item));
        var response = requiredItemService.saveRequiredItem(eventId, item, forceSave);
        return ResponseEntity.ok(response.successful());
    }

    @GetMapping(value = "/{eventId}")
    @Operation(summary = "Get a list of items for each event, including estimated costs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "409")
    })
    public ResponseEntity<Optional<RequiredItemsBudgetResponseDto>> getItems(
            @PathVariable("eventId") String eventId) {
        log.info(String.format("GET /api/required-items/:eventId   eventId : [ %s ]", eventId));

        var items = requiredItemService.getRequiredItems(eventId);
        return ResponseEntity.ok(items);
    }
}
