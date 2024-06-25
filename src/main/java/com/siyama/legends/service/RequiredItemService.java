package com.siyama.legends.service;

import com.siyama.legends.domain.RequiredItem;
import com.siyama.legends.dtos.request.ItemRequestDto;
import com.siyama.legends.dtos.response.ItemResponseDto;
import com.siyama.legends.dtos.response.ItemsBudgetResponseDto;

import java.util.List;

public interface RequiredItemService {
    RequiredItem saveRequiredItem(String eventId, ItemRequestDto itemRequirement);
    List<ItemsBudgetResponseDto> getRequiredItems(String eventId);
}
