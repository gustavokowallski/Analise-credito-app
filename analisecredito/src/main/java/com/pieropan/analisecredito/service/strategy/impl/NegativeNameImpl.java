package com.pieropan.analisecredito.service.strategy.impl;

import com.pieropan.analisecredito.domain.Proposal;
import com.pieropan.analisecredito.service.strategy.ScoreCalculation;

import java.util.Random;

public class NegativeNameImpl implements ScoreCalculation {
    @Override
    public int calculate(Proposal proposal) {
        if(negativeName()){
            throw new RuntimeException("Nome negativado");
        }
        return 100;
    }
    private boolean negativeName(){
        return new Random().nextBoolean();
    }
}
