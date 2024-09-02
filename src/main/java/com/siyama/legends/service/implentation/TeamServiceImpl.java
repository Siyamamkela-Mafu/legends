package com.siyama.legends.service.implentation;

import com.siyama.legends.dtos.request.TeamRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.mapper.TeamMapper;
import com.siyama.legends.repository.TeamRepository;
import com.siyama.legends.service.TeamService;
import com.siyama.legends.utils.LegendsUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;
    private TeamMapper teamMapper;

    @Override
    public SaveResponseDto saveTeam(TeamRequestDto teamRequestDto, boolean forceSave) {
        var team = teamMapper.teamDtoToTeam(teamRequestDto);
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

}
