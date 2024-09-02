package com.siyama.legends.mapper;

import com.siyama.legends.domain.Organisation;
import com.siyama.legends.dtos.request.OrganisationRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganisationMapper {

    Organisation organisationDtoToOrganisation(OrganisationRequestDto organisationRequestDto);

}
