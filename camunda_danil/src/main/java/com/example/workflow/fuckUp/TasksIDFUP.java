package com.example.workflow.fuckUp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TasksIDFUP {
    final ParserFUP parserFUP = new ParserFUP();
    public String json = null;
    public int size = 0;
    public List<Task> taskList;
    private ObjectMapper objectMapper = new ObjectMapper();

    public TasksIDFUP() {
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public String objectToJson(Object inputObject){
        String json = null;

        try {
            json = objectMapper.writeValueAsString(inputObject);
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        return json;
    }

    @Bean
    public void runTask(String[] tasks) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        Set<String> callDK = new HashSet<String>(Arrays.asList(tasks));

        for(String task : callDK){
            taskList = taskService.createTaskQuery().processDefinitionKey(task).list();

            size += taskList.stream().count();
        }

        String[] listId = new String[size];

        for(String task : callDK){
            taskList = taskService.createTaskQuery().processDefinitionKey(task).list();

            for(int i = 0; i < taskList.stream().count(); i++){
                listId[i] = taskList.get(i).getId();
            }
        }

        json = objectToJson(listId);
    }

    @Override
    public String toString() {
        return "TasksIDFUP{" +
                "json='" + json + '\'' +
                '}';
    }
}
