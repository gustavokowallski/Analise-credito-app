package com.pieropan.analisecredito.service;

import com.pieropan.analisecredito.domain.Proposal;
import com.pieropan.analisecredito.exceptions.StrategyException;
import com.pieropan.analisecredito.service.strategy.ScoreCalculation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisCreditService {
    private List<ScoreCalculation> scoreCalculationList;

    public AnalysisCreditService(List<ScoreCalculation> scoreCalculationList){
        this.scoreCalculationList = scoreCalculationList;
    }
    public void toAnalyze(Proposal proposal){
        try {
            boolean approved = scoreCalculationList.stream().mapToInt(impl -> impl.calculate(proposal)).sum() > 350;
            proposal.setApproved(approved);
        } catch (StrategyException e) {
            proposal.setApproved(false);
        }

    }
}
