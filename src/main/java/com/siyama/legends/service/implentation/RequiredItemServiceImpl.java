package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.RequiredItem;
import com.siyama.legends.dtos.request.ItemRequestDto;
import com.siyama.legends.repository.RequirementRepository;
import com.siyama.legends.service.RequiredItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    private RequiredItem buildItemRequirement(String eventId, ItemRequestDto itemRequestDto) {
        return RequiredItem.builder()
                .quantity(itemRequestDto.getQuantity()).
                name(itemRequestDto.getName())
                .unitPrice(itemRequestDto.getUnitPrice())
                .eventId(eventId)
                .build();
    }
}
