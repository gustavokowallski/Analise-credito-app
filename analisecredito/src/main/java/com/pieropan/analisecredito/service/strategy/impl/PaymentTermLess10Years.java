package com.pieropan.analisecredito.service.strategy.impl;

import com.pieropan.analisecredito.domain.Proposal;
import com.pieropan.analisecredito.service.strategy.PointCalculation;

public class PaymentTermLess10Years implements PointCalculation {
    @Override
    public int calculate(Proposal proposal) {
        return proposal.getPaymentTerm() <= 120 ? 80 : 0;
    }
}
