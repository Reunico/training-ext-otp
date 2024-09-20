package com.trainings.otp.handler;

import com.trainings.otp.service.LotteryService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExternalTaskSubscription("clear")
@RequiredArgsConstructor
public class ClearReg implements ExternalTaskHandler {

    private final LotteryService lotteryService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        lotteryService.clear();
        externalTaskService.complete(externalTask);
    }
}
