package com.example.azaniisp.service;

import com.example.azaniisp.dao.InstitutionDao;
import com.example.azaniisp.exception.BusinessRuleException;
import com.example.azaniisp.exception.ValidationException;
import com.example.azaniisp.model.InstitutionEntity;


public class RegistrationService {
    //Action one validate registration data
    //Save data to db
    //Transform state of registration
    //Displays a screen for payment for complemention for registration


    private final InstitutionDao institutionDao;

    public RegistrationService(InstitutionDao institutionDao) {
        this.institutionDao = institutionDao;
    }

    public InstitutionEntity register(InstitutionEntity institution) {
        validate(institution);

        if ( institutionDao.findByRegistrationNo(institution.getRegistrationNo()).isPresent()) {
            throw new BusinessRuleException("Registration number already exists");
        }
        return institutionDao.save(institution);
    }

    private void validate(InstitutionEntity institution) {
        check(!isBlank(institution.getRegistrationNo()), "Registration No cannot be blank");
        check(!isBlank(institution.getName()), "Name cannot be blank");
        check(institution.getInstitutionType() == null, "InstitutionType cannot be blank");
        check(isBlank(institution.getContactPhone()), "Contact Phone cannot be blank");
        check(isBlank(institution.getEmail()) && !institution.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"), "Email cannot be blank or invalid");
        check(isBlank(institution.getLocation()), "Location cannot be blank");
        check(isBlank(institution.getPhysicalAddress()), "Physical Address cannot be blank");;

    }

    private void check(boolean condition, String message) {
        if (!condition) {
            throw new ValidationException(message);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}
