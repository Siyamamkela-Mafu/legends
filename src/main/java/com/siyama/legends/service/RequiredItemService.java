package com.siyama.legends.service;

import com.siyama.legends.domain.RequiredItem;
import com.siyama.legends.dtos.request.ItemRequestDto;

public interface RequiredItemService {
    RequiredItem saveRequiredItem(String eventId, ItemRequestDto itemRequirement);
}
