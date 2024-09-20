package com.trainings.otp.service;

import com.trainings.otp.model.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> get();
    List<Participant> numerate(List<Participant> participants);

}
