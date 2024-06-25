package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.RequiredItem;
import com.siyama.legends.dtos.request.ItemRequestDto;
import com.siyama.legends.dtos.response.ItemsBudgetResponseDto;
import com.siyama.legends.repository.RequirementRepository;
import com.siyama.legends.service.RequiredItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequiredItemServiceImpl implements RequiredItemService {
    private final RequirementRepository requirementRepository;

    @Override
    public RequiredItem saveRequiredItem(String eventId, ItemRequestDto itemRequirement) {
        RequiredItem requiredItem = buildItemRequirement(eventId, itemRequirement);
        requirementRepository.save(requiredItem);
        return requiredItem;
    }

    @Override
    public List<ItemsBudgetResponseDto> getRequiredItems(String eventId) {

        return null;
    }

    private RequiredItem buildItemRequirement(String eventId, ItemRequestDto itemRequestDto) {
        return RequiredItem.builder()
                .quantity(itemRequestDto.getQuantity()).
                name(itemRequestDto.getName())
                .unitPrice(itemRequestDto.getUnitPrice())
                .eventId(eventId)
                .build();
    }
}
