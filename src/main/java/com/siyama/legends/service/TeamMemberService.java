package com.siyama.legends.service;


import com.siyama.legends.dtos.request.TeamMemberRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;

public interface TeamMemberService {
    SaveResponseDto saveTeamMember(TeamMemberRequestDto teamMemberRequestDto, boolean forceSave);
}
