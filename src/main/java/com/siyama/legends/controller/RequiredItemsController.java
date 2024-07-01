package com.siyama.legends.controller;


import com.siyama.legends.dtos.request.RequiredItemRequestDto;
import com.siyama.legends.dtos.response.RequiredItemsBudgetResponseDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.service.RequiredItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
            @ApiResponse(responseCode = "404")
    })
    //TODO :: Return an appropriate ResponseDto
    public ResponseEntity<String> addItem(
            @PathVariable("eventId") String eventId,
            @RequestBody RequiredItemRequestDto item,
            @RequestParam(value = "force", defaultValue = "false") boolean force
            ) {
        Boolean requiredItemExists = requiredItemService.checkIfExists(item.getName());
        if(requiredItemExists && !force){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new SaveResponseDto(item.getName()).alreadyExists());
        }
        var response = requiredItemService.saveRequiredItem(eventId, item);
        return ResponseEntity.ok(response.successful());
    }

    @GetMapping(value = "/{eventId}")
    @Operation(summary = "Get a list of items for each event, including estimated costs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404")
    })

    public ResponseEntity<Optional<RequiredItemsBudgetResponseDto>> getItems(
            @PathVariable("eventId") String eventId) {
        var items = requiredItemService.getRequiredItems(eventId);
        return ResponseEntity.ok(items);
    }
}
