package com.pieropan.analisecredito.service.strategy.impl;

import com.pieropan.analisecredito.domain.Proposal;
import com.pieropan.analisecredito.service.strategy.PointCalculation;

import java.util.Random;

public class OtherLoansInProgress implements PointCalculation {
    @Override
    public int calculate(Proposal proposal) {
        return otherLoansInProgress() ? 0 : 80 ;

    }
    private boolean otherLoansInProgress(){
        return new Random().nextBoolean();
    }
}
