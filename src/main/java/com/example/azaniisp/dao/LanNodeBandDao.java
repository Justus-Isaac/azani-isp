package com.example.azaniisp.dao;

import com.example.azaniisp.model.LanNodeBand;

import java.util.List;
import java.util.Optional;

public interface LanNodeBandDao {
    List<LanNodeBand> findAll();
    Optional<LanNodeBand> findById(int id);
}
