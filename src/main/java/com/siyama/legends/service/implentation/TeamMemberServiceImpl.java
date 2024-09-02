package com.siyama.legends.service.implentation;


import com.google.gson.Gson;
import com.siyama.legends.dtos.messaging.EmailMessageDto;
import com.siyama.legends.dtos.request.TeamMemberRequestDto;
import com.siyama.legends.dtos.response.SaveResponseDto;
import com.siyama.legends.exception.DoesNotExistException;
import com.siyama.legends.mapper.TeamMemberMapper;
import com.siyama.legends.repository.TeamMemberRepository;
import com.siyama.legends.repository.TeamRepository;
import com.siyama.legends.service.TeamMemberService;
import com.siyama.legends.utils.LegendsUtility;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {

    private TeamMemberRepository teamMemberRepository;
    private TeamRepository teamRepository;
    private RabbitTemplate rabbitTemplate;
    private TeamMemberMapper teamMemberMapper;
    @Value("${legends.email.notification.queue}")
    private String emailQueue;

    @Override
    public SaveResponseDto saveTeamMember(TeamMemberRequestDto teamMemberRequestDto, boolean forceSave) {
        var teamMember = teamMemberMapper.teamMemberDtoToTeamMember(teamMemberRequestDto);
        boolean requiredItemExists = checkIfExists(teamMemberRequestDto.getName(), teamMemberRequestDto.getSurname());
        if (requiredItemExists && !forceSave) {
            LegendsUtility.objectExistsAndNotForced(String.format("%s %s ", teamMember.getName(), teamMember.getSurname()));
        }
        var response = teamMemberRepository.save(teamMember);

        if (!response.id.isEmpty()) {
            this.sendEmailMessage(teamMemberRequestDto);
        }
        return new SaveResponseDto("team member");
    }

    public void sendEmailMessage(TeamMemberRequestDto teamMemberRequestDto) {
        var emailMessageDto = buildEmailMessage(teamMemberRequestDto);
        var message = new Gson().toJson(emailMessageDto);
        rabbitTemplate.convertAndSend(emailQueue, message);
    }

    private EmailMessageDto buildEmailMessage(TeamMemberRequestDto teamMemberRequestDto) {
        String body;
        var team = teamRepository.findById(teamMemberRequestDto.getTeamId());

        if (team.isPresent()) {
            body = String.format("You have been successfully assigned to the %s team", team.get().getName());
        } else
            throw new DoesNotExistException("Team");

        return EmailMessageDto
                .builder()
                .toEmail(teamMemberRequestDto.getEmail())
                .toName(teamMemberRequestDto.getName())
                .subject(String.format("Legends Team Assignment | %s", teamMemberRequestDto.getName()))
                .body(body)
                .build();
    }

    private boolean checkIfExists(String name, String surname) {
        return teamMemberRepository.existsByNameAndSurnameAndIsActiveTrue(name, surname);
    }

}
