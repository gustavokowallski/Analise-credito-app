package com.pieropan.analisecredito.service.strategy.impl;

import com.pieropan.analisecredito.domain.Proposal;
import com.pieropan.analisecredito.service.strategy.PointCalculation;

public class IncomeGreaterThanRequestedAmount implements PointCalculation {
    @Override
    public int calculate(Proposal proposal) {
        return incomeGreaterThanRequestedAmount(proposal) ? 100 :0 ;
    }

    private boolean incomeGreaterThanRequestedAmount(Proposal proposal){
        return proposal.getUser().getIncome() > proposal.getRequestedAmount();
    }
}
