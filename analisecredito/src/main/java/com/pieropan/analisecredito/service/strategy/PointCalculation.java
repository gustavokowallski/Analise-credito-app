package com.pieropan.analisecredito.service.strategy;

import com.pieropan.analisecredito.domain.Proposal;

public interface PointCalculation {
    int calculate(Proposal proposal);
}
