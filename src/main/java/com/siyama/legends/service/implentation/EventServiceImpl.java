package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.Event;
import com.siyama.legends.dtos.request.EventRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.repository.EventRepository;
import com.siyama.legends.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Override
    public SaveResponseDto saveEvent(EventRequestDto eventRequestDto) {
        Event event = buildEvent(eventRequestDto);
        eventRepository.save(event);
        return new SaveResponseDto("Event");
    }

    private Event buildEvent(EventRequestDto eventRequestDto) {
        return Event.builder()
                .eventName(eventRequestDto.getEventName())
                .startDate(eventRequestDto.getStartDate())
                .endDate(eventRequestDto.getEndDate())
                .expectedPeople(eventRequestDto.getExpectedPeople())
                .location(eventRequestDto.getLocation())
                .build();
    }
}
