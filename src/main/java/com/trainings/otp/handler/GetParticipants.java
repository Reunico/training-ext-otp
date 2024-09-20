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
@ExternalTaskSubscription(value = "get-participants", lockDuration = 60000)
@Configuration
@Slf4j
public class GetParticipants implements ExternalTaskHandler {

    private final ParticipantService participantService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        log.warn("=== Get participants ===");
        List<Participant> participants = participantService.get();
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("participants", participants);
        externalTaskService.extendLock(externalTask, 98798809L);
        externalTaskService.complete(externalTask, variables);

    }
}
