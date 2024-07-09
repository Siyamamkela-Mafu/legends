package com.siyama.legends.controller;


import com.siyama.legends.dtos.request.TeamMemberRequestDto;
import com.siyama.legends.service.TeamMemberService;
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


@Tag(name = "Teams Members")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/team-members")
public class TeamMemberController {
    private final TeamMemberService teamMemberService;

    @PostMapping(value = "/{teamId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add team member to a team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "400"),
            @ApiResponse(responseCode = "404"),
            @ApiResponse(responseCode = "409")
    })
    public ResponseEntity<String> save(
            @PathVariable("teamId") String teamId,
            @RequestParam(value = "force", defaultValue = "false") boolean forceSave,
            @RequestBody @Valid TeamMemberRequestDto teamMemberRequestDto
    ) {
        log.info(String.format("POST /api/team-members/:teamId  organisationId: [ %s ] teamMember: [ %s ] ", teamId, teamMemberRequestDto));
        teamMemberRequestDto.setTeamId(teamId);
        var response = teamMemberService.saveTeamMember(teamMemberRequestDto, forceSave);
        return ResponseEntity.ok(response.successful());
    }
}
