package com.siyama.legends.controller;


import com.siyama.legends.dtos.request.OrganisationRequestDto;
import com.siyama.legends.service.OrganisationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Organisations")
@Order(1)
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/organisations")
public class OrganisationController {
    private final OrganisationService organisationService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add new organisation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "409")
    })
    public ResponseEntity<String> saveOrganisation(
            @RequestParam(value = "forceSave", defaultValue = "false") boolean forceSave,
            @RequestBody @Valid OrganisationRequestDto organisationRequestDto
    ) {
        log.info(String.format("POST /api/organisations/ organisation: [ %s ] ", organisationRequestDto));
        var response = organisationService.saveOrganisation(organisationRequestDto, forceSave);
        return ResponseEntity.ok(response.successful());
    }
}
