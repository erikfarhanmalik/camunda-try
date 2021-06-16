package com.erik.learn.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Optional;
import java.util.logging.Logger;

public class ReviewApprovalBoardDelegate implements JavaDelegate {
    private final Logger logger = Logger.getLogger(ReviewApprovalBoardDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String creatorEmailAddress = (String) Optional.ofNullable(execution.getVariable("creatorEmailAddress")).orElse(null);
        boolean isNeedApproval = Optional.ofNullable(execution.getVariable("isNeedApproval"))
                .map(v -> (boolean) v)
                .orElse(false);

        logger.info("Set creatorEmailAddress to " + creatorEmailAddress);
        logger.info("Set isNeedApproval to " + isNeedApproval);

        execution.setVariable("creatorEmailAddress", creatorEmailAddress);
        execution.setVariable("isNeedApproval", isNeedApproval);
    }
}
