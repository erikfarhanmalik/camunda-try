package com.erik.learn.runner;

import com.erik.learn.CamundaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Runner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);
    private final CamundaClient camundaClient;

    public Runner(CamundaClient camundaClient) {
        this.camundaClient = camundaClient;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Begin to start watchMovie process");
        Thread.sleep(5000);
        logger.info("Starting watchMovie process");
        String processInstanceId = camundaClient.startProcess("watchMovie", new HashMap<>()).getProcessInstanceId();
        logger.info("processInstanceId: {}", processInstanceId);

        Thread.sleep(5000);
        logger.info("Completing pickMovie task");
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("selectedMovie", "The Matrix");
        camundaClient.completeUserTask(processInstanceId, "pickMovie", variables);
        logger.info("Completed!");
    }
}
