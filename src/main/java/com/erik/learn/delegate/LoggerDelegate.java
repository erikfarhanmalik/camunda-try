package com.erik.learn.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class LoggerDelegate implements JavaDelegate {
    private final Logger logger = Logger.getLogger(LoggerDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("\n" +
                "... Logger Delegate invoked by\n" +
                "- processDefinitionId: " + execution.getProcessDefinitionId() + "\n" +
                "- currentActivityId: " + execution.getCurrentActivityId() + "\n" +
                "- currentActivityName: " + execution.getCurrentActivityName() + "\n" +
                "- processInstanceId: " + execution.getProcessInstanceId() + "\n" +
                "- processBusinessKey: " + execution.getProcessBusinessKey() + "\n" +
                "- id: " + execution.getId() + "\n");
    }
}
