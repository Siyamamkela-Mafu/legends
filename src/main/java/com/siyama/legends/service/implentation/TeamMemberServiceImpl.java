package com.siyama.legends.service.implentation;

import com.siyama.legends.domain.TeamMember;
import com.siyama.legends.dtos.request.TeamMemberRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.repository.TeamMemberRepository;
import com.siyama.legends.service.TeamMemberService;
import com.siyama.legends.utils.LegendsUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository teamRepository;

    @Override
    public SaveResponseDto saveTeamMember(TeamMemberRequestDto teamMemberRequestDto, boolean forceSave) {
        var teamMember = buildTeamMemberDomain(teamMemberRequestDto);
        boolean requiredItemExists = checkIfExists(teamMemberRequestDto.getName(), teamMemberRequestDto.getSurname());
        if (requiredItemExists && !forceSave) {
            LegendsUtility.objectExistsAndNotForced(String.format("%s %s ", teamMember.getName(), teamMember.getSurname()));
        }
        teamRepository.save(teamMember);
        return new SaveResponseDto("team member");
    }

    private boolean checkIfExists(String name, String surname) {
        return teamRepository.existsByNameAndSurnameAndIsActiveTrue(name, surname);
    }

    private TeamMember buildTeamMemberDomain(TeamMemberRequestDto teamMemberRequestDto) {
        return TeamMember.builder()
                .name(teamMemberRequestDto.getName())
                .surname(teamMemberRequestDto.getSurname())
                .email(teamMemberRequestDto.getEmail())
                .role(teamMemberRequestDto.getRole())
                .teamId(teamMemberRequestDto.getTeamId())
                .contactNo(teamMemberRequestDto.getContactNo())
                .isActive(true)
                .build();
    }

}
