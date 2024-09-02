package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.Event;
import com.siyama.legends.dtos.request.EventRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.mapper.EventMapper;
import com.siyama.legends.repository.EventRepository;
import com.siyama.legends.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public SaveResponseDto saveEvent(EventRequestDto eventRequestDto) {
        Event event = eventMapper.eventDtoToEvent(eventRequestDto);
        eventRepository.save(event);
        return new SaveResponseDto("Event");
    }

}
