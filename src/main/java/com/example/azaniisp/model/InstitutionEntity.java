package com.example.azaniisp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstitutionEntity extends AbstractEntity {
    private String registrationNo;
    private String name;
    private InstitutionType institutionType;
    private String contactPhone;
    private String email;
    private String location;
    private String physicalAddress;
    private LocalDate registrationDate;
    private InstitutionStatus status;

    @Override
    public String toString() {
        return name + " (" + registrationNo +")";
    }
}
