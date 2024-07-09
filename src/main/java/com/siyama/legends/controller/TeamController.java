package com.siyama.legends.controller;


import com.siyama.legends.dtos.request.TeamRequestDto;
import com.siyama.legends.service.TeamService;
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


@Tag(name = "Teams")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/teams")
public class TeamController {
    private final TeamService teamService;

    @PostMapping(value = "/{organisationId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add organisation team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "409")
    })
    public ResponseEntity<String> save(
            @PathVariable("organisationId") String organisationId,
            @RequestParam(value = "force", defaultValue = "false") boolean forceSave,
            @RequestBody @Valid TeamRequestDto teamRequestDto
    ) {
        log.info(String.format("POST /api/teams/:organisationId  organisationId: [ %s ] team: [ %s ] ", organisationId, teamRequestDto));
        teamRequestDto.setOrganisationId(organisationId);
        var response = teamService.saveTeam(teamRequestDto, forceSave);
        return ResponseEntity.ok(response.successful());
    }
}
