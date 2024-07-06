package com.siyama.legends.service;

import com.siyama.legends.dtos.request.RequiredItemRequestDto;
import com.siyama.legends.dtos.response.RequiredItemsBudgetResponseDto;
import com.siyama.legends.dtos.response.SaveResponseDto;

import java.util.Optional;

public interface RequiredItemService {
    boolean checkIfExists(String name);
    SaveResponseDto saveRequiredItem(String eventId, RequiredItemRequestDto itemRequirement);
    Optional<RequiredItemsBudgetResponseDto> getRequiredItems(String eventId);
}
