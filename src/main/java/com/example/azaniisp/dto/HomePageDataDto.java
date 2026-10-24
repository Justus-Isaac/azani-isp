package com.example.azaniisp.dto;

import com.example.azaniisp.model.BandwidthTier;
import com.example.azaniisp.model.LanNodeBand;

import java.util.List;

public record HomePageDataDto(
        List<BandwidthTier> bandwidthTiers,
        List<LanNodeBand> lanNodeBands
) {}
