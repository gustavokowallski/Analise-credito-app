package com.pieropan.analisecredito.listener;

import com.pieropan.analisecredito.domain.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProposalUnderAnalysisListener {
    @RabbitListener(queues = "${rabbitmq.queue.pendingproposal}")
    public void proposalUnderAnalysis (Proposal proposal){

    }
}
