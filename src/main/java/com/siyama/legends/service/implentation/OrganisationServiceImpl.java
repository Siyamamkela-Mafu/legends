package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.Organisation;
import com.siyama.legends.dtos.request.OrganisationRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.repository.OrganisationRepository;
import com.siyama.legends.service.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private final OrganisationRepository organisationRepository;

    @Override
    public SaveResponseDto saveOrganisation(OrganisationRequestDto organisationRequestDto) {
        var organisation = buildOrganisation(organisationRequestDto);
        organisationRepository.save(organisation);
        return new SaveResponseDto("organisation");
    }

    @Override
    public Boolean checkIfExists(String organisationName) {
        return organisationRepository.existsByNameAndIsActiveTrue(organisationName);
    }

    private Organisation buildOrganisation(OrganisationRequestDto organisationRequestDto) {
        return Organisation.builder()
                .name(organisationRequestDto.getName())
                .isActive(true)
                .build();
    }

}
