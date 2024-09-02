package com.siyama.legends.mapper;

import com.siyama.legends.domain.Team;
import com.siyama.legends.domain.TeamMember;
import com.siyama.legends.dtos.request.TeamMemberRequestDto;
import com.siyama.legends.dtos.request.TeamRequestDto;
import com.siyama.legends.dtos.response.TeamMemberResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMemberMapper {
    TeamMember teamMemberDtoToTeamMember(TeamMemberRequestDto teamMemberRequestDto);
    TeamMemberResponseDto teamMemberToTeamMemberDto(TeamMember teamMember);
}
