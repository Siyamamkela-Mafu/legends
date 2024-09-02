package com.siyama.legends.mapper;

import com.siyama.legends.domain.RequiredItem;
import com.siyama.legends.dtos.request.RequiredItemRequestDto;
import com.siyama.legends.dtos.response.RequiredItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequiredItemMapper {
    RequiredItem requiredItemDtoToRequiredItem(RequiredItemRequestDto requiredItemRequestDto);

    RequiredItemResponseDto requiredItemToDto(RequiredItem requiredItem);
}
