package com.erik.learn.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Random;
import java.util.logging.Logger;

public class CheckWeatherDelegate implements JavaDelegate {
    private final Logger logger = Logger.getLogger(CheckWeatherDelegate.class.getName());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        boolean weatherOk = new Random().nextBoolean();
        logger.info("Set weatherOk as " + weatherOk);
        execution.setVariable("name", "erik");
        execution.setVariable("weatherOk", weatherOk);
    }
}
