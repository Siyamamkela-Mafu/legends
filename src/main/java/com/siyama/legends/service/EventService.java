package com.siyama.legends.service;


import com.siyama.legends.domain.Event;
import com.siyama.legends.dtos.request.EventRequestDto;

public interface EventService {
    Event saveEvent(EventRequestDto eventRequestDto);
}
