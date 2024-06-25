package com.siyama.legends.controller;


import com.siyama.legends.dtos.request.ItemRequestDto;
import com.siyama.legends.service.RequiredItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ItemRequestDto> addItem(
            @PathVariable("eventId") String eventId,
            @RequestBody ItemRequestDto item) {
        requiredItemService.saveRequiredItem(eventId, item);
        return ResponseEntity.ok(item);
    }
}
