package com.example.azaniisp.controller;

import com.example.azaniisp.service.RegistrationService;

public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
