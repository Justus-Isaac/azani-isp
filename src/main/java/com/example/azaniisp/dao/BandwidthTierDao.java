package com.example.azaniisp.dao;

import com.example.azaniisp.model.BandwidthTier;

import java.util.List;
import java.util.Optional;

public interface BandwidthTierDao {
    List<BandwidthTier> findAll();
    Optional<BandwidthTier> findById(int id);
}
