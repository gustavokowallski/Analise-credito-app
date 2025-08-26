package com.pieropan.analisecredito.service.strategy.impl;

import com.pieropan.analisecredito.domain.Proposal;
import com.pieropan.analisecredito.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScoreImpl implements ScoreCalculation {
    @Override
    public int calculate(Proposal proposal) {
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
