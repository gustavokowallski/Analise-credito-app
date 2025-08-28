package com.pieropan.analisecredito.service;

import com.pieropan.analisecredito.domain.Proposal;
import com.pieropan.analisecredito.exceptions.StrategyException;
import com.pieropan.analisecredito.service.strategy.ScoreCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalysisCreditService {

    @Autowired
    private List<ScoreCalculation> scoreCalculationList;

    @Value("${rabbitmq.completedproposal.exchange}")
    private String exchangeProposalConcluded;

    @Autowired
    private NotificationRabbitMQService notificacaoRabbitMQService;

    public void toAnalyze(Proposal proposal){
        try {
            int pontos = scoreCalculationList.stream().mapToInt(impl -> impl.calculate(proposal)).sum();
            proposal.setApproved(pontos > 350);
        } catch (StrategyException e) {
            proposal.setApproved(false);
            proposal.setObservation(e.getMessage());
        }
        notificacaoRabbitMQService.toNotify(exchangeProposalConcluded, proposal);
    }
}
