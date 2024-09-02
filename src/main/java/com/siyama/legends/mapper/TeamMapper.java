package com.siyama.legends.mapper;

import com.siyama.legends.domain.Team;
import com.siyama.legends.dtos.request.TeamRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    Team teamDtoToTeam(TeamRequestDto teamRequestDto);
    TeamRequestDto teamToTeamDto(Team team);
}
