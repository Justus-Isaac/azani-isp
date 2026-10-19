package com.example.azaniisp.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractEntity {
    private int id;
    private LocalDateTime createdAt;

    public boolean isNew() { return id == 0; }
}
