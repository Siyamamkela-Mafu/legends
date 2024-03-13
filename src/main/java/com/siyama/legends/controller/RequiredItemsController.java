package com.siyama.legends.controller;

import com.siyama.legends.dtos.request.ItemRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/required-items")
public class RequiredItemsController {
    @PostMapping(value = "/{eventId}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404")
    })
    public String addItem(@PathVariable("eventId") String eventId, @RequestBody ItemRequestDto item){

        return item + " for " +  eventId + " saved successfully";
    }
}
