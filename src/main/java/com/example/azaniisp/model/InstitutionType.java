package com.example.azaniisp.model;

public enum InstitutionType {
    PRIMARY("Primary school"),
    JUNIOR("Junior school"),
    SENIOR("Senior school"),
    COLLEGE("College");

    private final String label;
    InstitutionType(String label) { this.label = label; }

    @Override
    public String toString() { return label; }
}
