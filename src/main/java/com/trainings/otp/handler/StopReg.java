package com.trainings.otp.handler;

import com.trainings.otp.service.LotteryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExternalTaskSubscription("stop-reg")
@RequiredArgsConstructor
@Slf4j
public class StopReg implements ExternalTaskHandler {

    private final LotteryService lotteryService;

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        log.warn("===== Stop Reg");
        lotteryService.stop();
        externalTaskService.complete(externalTask);
    }
}
