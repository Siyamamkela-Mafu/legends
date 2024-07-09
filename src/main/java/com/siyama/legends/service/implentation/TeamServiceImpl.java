package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.Team;
import com.siyama.legends.dtos.request.TeamRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.repository.TeamRepository;
import com.siyama.legends.service.TeamService;
import com.siyama.legends.utils.LegendsUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public SaveResponseDto saveTeam(TeamRequestDto teamRequestDto, boolean forceSave) {
        var team = buildTeamDomain(teamRequestDto);
        boolean requiredItemExists = checkIfExists(team.getName());
        if (requiredItemExists && !forceSave) {
            LegendsUtility.objectExistsAndNotForced(team.getName());
        }
        teamRepository.save(team);
        return new SaveResponseDto("team");
    }

    private boolean checkIfExists(String teamName) {
        return teamRepository.existsByNameAndIsActiveTrue(teamName);
    }

    private Team buildTeamDomain(TeamRequestDto teamRequestDto) {
        return Team.builder()
                .name(teamRequestDto.getName())
                .organisationId(teamRequestDto.getOrganisationId())
                .isActive(true)
                .build();
    }

}
