package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.RequiredItem;
import com.siyama.legends.dtos.request.RequiredItemRequestDto;
import com.siyama.legends.dtos.response.RequiredItemResponseDto;
import com.siyama.legends.dtos.response.RequiredItemsBudgetResponseDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.repository.RequirementRepository;
import com.siyama.legends.service.RequiredItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequiredItemServiceImpl implements RequiredItemService {
    private final RequirementRepository requirementRepository;

    @Override
    public boolean checkIfExists(String name) {
        return requirementRepository.existsByNameContaining(name.trim());
    }

    @Override
    public SaveResponseDto saveRequiredItem(String eventId, RequiredItemRequestDto requiredItemRequestDto) {
        RequiredItem requiredItem = buildItemRequiredRequestDto(eventId, requiredItemRequestDto);
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
        requiredItemsBudgetResponseDto.setEventId(eventId);
        if (requiredItems.size() > 0) {
            var requiredItemResponseDto = buildItemsRequiredResponseDto(requiredItems);
            requiredItemsBudgetResponseDto.setItems(requiredItemResponseDto);

            Integer totalItems = requiredItems.size();
            requiredItemsBudgetResponseDto.setTotalItems(totalItems);

            requiredItems.forEach(item -> {
                BigDecimal currentTotalCost = requiredItemsBudgetResponseDto.getEstimatedTotalCost();
                requiredItemsBudgetResponseDto.setEstimatedTotalCost(currentTotalCost.add(item.getUnitPrice()));
            });
        }
        return requiredItemsBudgetResponseDto;
    }

    private RequiredItem buildItemRequiredRequestDto(String eventId, RequiredItemRequestDto requiredItemRequestDto) {
        return RequiredItem.builder()
                .quantity(requiredItemRequestDto.getQuantity()).
                name(requiredItemRequestDto.getName())
                .unitPrice(requiredItemRequestDto.getUnitPrice())
                .eventId(eventId)
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
            requiredItemsResponseDto.add(requiredItemResponseDto);
        });
        return requiredItemsResponseDto;
    }
}
