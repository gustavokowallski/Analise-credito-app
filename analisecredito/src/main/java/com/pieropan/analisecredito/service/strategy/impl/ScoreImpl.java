package com.pieropan.analisecredito.service.strategy.impl;

import com.pieropan.analisecredito.service.strategy.PointCalculation;

import java.util.Random;

public class ScoreImpl implements PointCalculation {
    @Override
    public int calculate() {
        int score = score();
        if(score <= 200){
            throw new RuntimeException("Score abaixo do permitido");
        } else if (score <= 400){
            return 150;
        }
        else if (score <= 600){
            return 180;
        } else {
            return 220;
        }
    }
    private int score(){
        return new Random().nextInt(0, 1000);
    }
}
