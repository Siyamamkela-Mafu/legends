package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.Event;
import com.siyama.legends.domain.RequiredItem;
import com.siyama.legends.domain.TeamMember;
import com.siyama.legends.dtos.request.RequiredItemRequestDto;
import com.siyama.legends.dtos.response.*;
import com.siyama.legends.repository.EventRepository;
import com.siyama.legends.repository.RequirementRepository;
import com.siyama.legends.repository.TeamMemberRepository;
import com.siyama.legends.service.RequiredItemService;
import com.siyama.legends.utils.LegendsUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RequiredItemServiceImpl implements RequiredItemService {
    private final RequirementRepository requirementRepository;
    private final TeamMemberRepository teamMemberRepository;
    private final EventRepository eventRepository;


    @Override
    public boolean checkIfExists(String name) {
        return requirementRepository.existsByNameContaining(name.trim());
    }

    @Override
    public SaveResponseDto saveRequiredItem(String eventId, RequiredItemRequestDto requiredItemRequestDto, boolean forceSave) {
        RequiredItem requiredItem = buildItemRequiredRequestDto(eventId, requiredItemRequestDto);

        boolean requiredItemExists = this.checkIfExists(requiredItem.getName());
        if (requiredItemExists && !forceSave) {
            LegendsUtility.objectExistsAndNotForced(requiredItem.getName());
        }
        requirementRepository.save(requiredItem);
        return new SaveResponseDto("Required item");
    }

    @Override
    public Optional<RequiredItemsBudgetResponseDto> getRequiredItems(String eventId) {
        var requiredItems = requirementRepository.findAllByEventId(eventId);
        return Optional.of(buildBudget(eventId, requiredItems));
    }

    private RequiredItemsBudgetResponseDto buildBudget(String eventId, List<RequiredItem> requiredItems) {
        RequiredItemsBudgetResponseDto requiredItemsBudgetResponseDto = new RequiredItemsBudgetResponseDto();
        var event = eventRepository.findById(eventId);
        event.ifPresent(value -> requiredItemsBudgetResponseDto.setEvent(buildEventResponseDto(value)));

        if (requiredItems.size() > 0) {
            var requiredItemResponseDto = buildItemsRequiredResponseDto(requiredItems);
            requiredItemsBudgetResponseDto.setItems(requiredItemResponseDto);

            Integer totalItems = requiredItems.size();
            requiredItemsBudgetResponseDto.setTotalItems(totalItems);
            requiredItemsBudgetResponseDto.setEstimatedTotalCost(calculateEstimatedTotalCost(requiredItems));
        }
        return requiredItemsBudgetResponseDto;
    }

    private BigDecimal calculateEstimatedTotalCost(List<RequiredItem> requiredItems) {
        BigDecimal currentTotalCost = BigDecimal.ZERO;
        for (RequiredItem requiredItem : requiredItems) {
            currentTotalCost = currentTotalCost.add(requiredItem.getUnitPrice());
        }
        return currentTotalCost;
    }

    private List<TeamMemberResponseDto> mapTeamMembers(List<String> teamMemberIds) {
        var teamMembers = teamMemberRepository.findAllByIdIn(teamMemberIds);
        return teamMembers.stream()
                .map(this::buildTeamMemberResponseDto)
                .collect(Collectors.toList());
    }

    private TeamMemberResponseDto buildTeamMemberResponseDto(TeamMember teamMember) {
        return TeamMemberResponseDto.builder()
                .id(teamMember.id)
                .name(teamMember.getName())
                .surname(teamMember.getSurname())
                .build();
    }

    private ItemDetailEventResponseDto buildEventResponseDto(Event event) {
        return ItemDetailEventResponseDto.builder()
                .id(event.id)
                .name(event.getName())
                .build();
    }

    private RequiredItem buildItemRequiredRequestDto(String eventId, RequiredItemRequestDto requiredItemRequestDto) {
        return RequiredItem.builder()
                .quantity(requiredItemRequestDto.getQuantity()).
                name(requiredItemRequestDto.getName())
                .unitPrice(requiredItemRequestDto.getUnitPrice())
                .eventId(eventId)
                .teamMemberIds(requiredItemRequestDto.teamMemberIds)
                .build();
    }

    private List<RequiredItemResponseDto> buildItemsRequiredResponseDto(List<RequiredItem> requiredItems) {
        List<RequiredItemResponseDto> requiredItemsResponseDto = new ArrayList<>();
        requiredItems.forEach(requiredItem -> {
            var requiredItemResponseDto = new RequiredItemResponseDto();
            requiredItemResponseDto.setId(requiredItem.id);
            requiredItemResponseDto.setQuantity(requiredItem.getQuantity());
            requiredItemResponseDto.setName(requiredItem.getName());
            requiredItemResponseDto.setUnitPrice(requiredItem.getUnitPrice());
            requiredItemResponseDto.setTeamMembers(mapTeamMembers(List.of(requiredItem.teamMemberIds)));
            requiredItemsResponseDto.add(requiredItemResponseDto);
        });
        return requiredItemsResponseDto;
    }
}
