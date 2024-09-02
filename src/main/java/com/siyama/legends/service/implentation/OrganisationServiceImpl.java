package com.siyama.legends.service.implentation;

import com.siyama.legends.dtos.request.OrganisationRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.mapper.OrganisationMapper;
import com.siyama.legends.repository.OrganisationRepository;
import com.siyama.legends.service.OrganisationService;
import com.siyama.legends.utils.LegendsUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationRepository organisationRepository;
    private OrganisationMapper organisationMapper;

    @Override
    public SaveResponseDto saveOrganisation(OrganisationRequestDto organisationRequestDto, boolean forceSave) {
        var organisation = organisationMapper.organisationDtoToOrganisation(organisationRequestDto);

        boolean organisationExists = this.checkIfExists(organisationRequestDto.getName());

        if (organisationExists && !forceSave) {
            LegendsUtility.objectExistsAndNotForced(organisationRequestDto.getName());
        }
        organisationRepository.save(organisation);
        return new SaveResponseDto("organisation");
    }

    @Override
    public Boolean checkIfExists(String organisationName) {
        return organisationRepository.existsByNameAndIsActiveTrue(organisationName);
    }
}
