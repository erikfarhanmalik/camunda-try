package com.erik.learn.runner;

import com.erik.learn.CamundaClient;
import com.erik.learn.entity.RequestToProcessMapping;
import com.erik.learn.repository.RequestToProcessMappingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Slf4j
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final CamundaClient camundaClient;
    private final RequestToProcessMappingRepository requestToProcessMappingRepository;

    @Override
    public void run(String... args) throws Exception {
//        testDb();
//        testProcess();
    }

    private void testProcess() throws InterruptedException {
        log.info("Begin to start watchMovie process");
        Thread.sleep(5000);
        log.info("Starting watchMovie process");
        String processInstanceId = camundaClient.startProcess("watchMovie", new HashMap<>()).getProcessInstanceId();
        log.info("processInstanceId: {}", processInstanceId);

        Thread.sleep(5000);
        log.info("Completing pickMovie task");
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("selectedMovie", "The Matrix");
        camundaClient.completeUserTask(processInstanceId, "pickMovie", variables);
        log.info("Completed!");
    }

    private void testDb() {
        RequestToProcessMapping mapping = new RequestToProcessMapping(999L, "999L");
        mapping = requestToProcessMappingRepository.save(mapping);
        RequestToProcessMapping finalMapping = mapping;
        mapping = requestToProcessMappingRepository.findById(mapping.getId())
                .orElseThrow(() -> new RuntimeException("Could not find mapping with id: " + finalMapping.getId()));
        System.out.println("mark: " + mapping.getRequestId());
    }
}
