package com.trainings.otp.handler;

import com.trainings.otp.model.Participant;
import com.trainings.otp.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ExternalTaskSubscription("notify")
@RequiredArgsConstructor
@Slf4j
public class Notify implements ExternalTaskHandler {

    private final NotificationService notificationService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

        log.warn("=== Notify participant === ");

        Number chatId = externalTask.getVariable("chatId");
        String message = externalTask.getVariable("message");
        log.warn("=== Notify participant === {} {}", chatId, message);

        // notificationService.notify(chatId, message);
        externalTaskService.complete(externalTask);

    }
}
