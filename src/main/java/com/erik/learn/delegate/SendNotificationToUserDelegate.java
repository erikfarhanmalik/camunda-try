package com.erik.learn.delegate;

import com.erik.learn.service.EmailNotificationService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Optional;

public class SendNotificationToUserDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String creatorEmailAddress = (String) Optional.ofNullable(execution.getVariable("creatorEmailAddress")).orElse(null);
        boolean approved = true;

        if (Optional.ofNullable(execution.getVariable("approved")).isPresent()) {
            approved = Optional.ofNullable(execution.getVariable("approved"))
                    .map(v -> (boolean) v)
                    .orElse(false);
        }
        if (approved) {
            new EmailNotificationService().send(creatorEmailAddress, "Board created For you!");
        } else {
            new EmailNotificationService().send(creatorEmailAddress, "Your Board creation is rejected!");
        }
    }
}
