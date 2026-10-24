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
public class LanNodeBand extends AbstractEntity {
    private int bandId;
    private int minNodes;
    private int maxNodes;
    private BigDecimal cost;

    @Override
    public String toString() { return minNodes + "-" + maxNodes + "nodes"; }
}
