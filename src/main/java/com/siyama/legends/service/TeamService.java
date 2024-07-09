package com.siyama.legends.service;


import com.siyama.legends.dtos.request.TeamRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;

public interface TeamService {
    SaveResponseDto saveTeam(TeamRequestDto teamRequestDto, boolean forceSave);
}
