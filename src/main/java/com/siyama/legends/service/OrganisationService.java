package com.siyama.legends.service;


import com.siyama.legends.dtos.request.OrganisationRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;

public interface OrganisationService {
    SaveResponseDto saveOrganisation(OrganisationRequestDto organisationRequestDto, boolean forceSave);
    Boolean checkIfExists(String organisationName);
}
