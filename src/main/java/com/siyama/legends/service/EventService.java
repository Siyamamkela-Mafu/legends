package com.siyama.legends.service;


import com.siyama.legends.dtos.request.EventRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;

public interface EventService {
    SaveResponseDto saveEvent(EventRequestDto eventRequestDto);
}
