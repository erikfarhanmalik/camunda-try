package com.erik.learn;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CamundaClient {
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    public CamundaClient(RuntimeService runtimeService, TaskService taskService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
    }

    public ProcessInstance startProcess(String processDefinitionKey, Map<String, Object> variables) {
        return runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);
    }

    public void completeUserTask(String processInstanceId, String taskName, Map<String, Object> variables) {
        // taskService is instance of org.camunda.bpm.engine.TaskService
        String taskId = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .list()
                .stream()
                .filter(task -> task.getTaskDefinitionKey().equals(taskName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        String.format("Could not find task with name %s on processInstanceId %s",
                                taskName,
                                processInstanceId))).getId();
        taskService.complete(taskId, variables);
    }
}
