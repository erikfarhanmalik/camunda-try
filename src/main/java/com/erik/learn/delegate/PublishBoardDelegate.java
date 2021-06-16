package com.erik.learn.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class PublishBoardDelegate implements JavaDelegate {
    private final Logger logger = Logger.getLogger(PublishBoardDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        logger.info("Publish the board!");
    }
}
