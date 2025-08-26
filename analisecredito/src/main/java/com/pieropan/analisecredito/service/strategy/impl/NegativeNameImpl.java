package com.pieropan.analisecredito.service.strategy.impl;

import com.pieropan.analisecredito.service.strategy.PointCalculation;

import java.util.Random;

public class NegativeNameImpl implements PointCalculation {
    @Override
    public int calculate() {
        if(negativeName()){
            throw new RuntimeException("Nome negativado");
        }
        return 100;
    }
    private boolean negativeName(){
        return new Random().nextBoolean();
    }
}
