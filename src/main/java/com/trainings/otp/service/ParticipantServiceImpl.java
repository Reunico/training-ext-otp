package com.trainings.otp.service;

import com.trainings.otp.config.ApplicationProperties;
import com.trainings.otp.model.Participant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ApplicationProperties applicationProperties;
    private final RestTemplate restTemplate;

    public ParticipantServiceImpl(ApplicationProperties applicationProperties, @Qualifier("authenticatedTemplate") RestTemplate restTemplate) {
        this.applicationProperties = applicationProperties;
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Participant> get() {
        return (List<Participant>) restTemplate.getForObject(applicationProperties.getParticipantUrl(), List.class);
    }

    @Override
    public List<Participant> numerate(List<Participant> participants) {
        return (List<Participant>) restTemplate.postForObject(applicationProperties.getNumberingUrl(), participants, List.class);
    }
}
