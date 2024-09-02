package com.siyama.legends.mapper;

import com.siyama.legends.domain.Event;
import com.siyama.legends.dtos.request.EventRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {

    Event eventDtoToEvent(EventRequestDto eventRequestDto);

    EventRequestDto eventToEventDto(Event event);

}
