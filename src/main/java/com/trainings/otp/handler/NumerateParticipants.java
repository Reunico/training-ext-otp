package com.trainings.otp.handler;

import com.trainings.otp.model.Participant;
import com.trainings.otp.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;


@RequiredArgsConstructor
@ExternalTaskSubscription("numerate-participants")
@Configuration
@Slf4j
public class NumerateParticipants implements ExternalTaskHandler {

    private final ParticipantService participantService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        log.warn("=== Numerate Participants ===");

        List<Participant> participants = externalTask.getVariable("participants");

        participants = participantService.numerate(participants);

        HashMap<String, Object> variables = new HashMap<>();
        variables.put("participants", participants);

        externalTaskService.complete(externalTask, variables);

    }
}
