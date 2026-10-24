package com.example.azaniisp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BandwidthTier extends  AbstractEntity {
    private int tierId;
    private int bandwidthMbps;
    private BigDecimal monthlyCost;

    @Override
    public String toString() { return  bandwidthMbps + "mbps"; }
}
