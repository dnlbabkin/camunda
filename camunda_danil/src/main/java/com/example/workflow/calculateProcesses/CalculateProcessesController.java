package com.example.workflow.calculateProcesses;

import com.example.workflow.jsonMap.JsonMapping;
import com.example.workflow.jsonMap.MappingJson;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.task.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateProcessesController {
    CalculateProcesses calculateProcesses = new CalculateProcesses();

    @GetMapping(value = "/camunda/rest-api/calc", produces = "application/java")
    @ResponseBody
    public ResponseEntity<?> calcProcesses(@RequestParam String team){

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        if(team.equals("TeamA")){
            List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("TeamA").processVariableValueEquals("gender", "male").list();
            List<Task> tasks2 = taskService.createTaskQuery().processDefinitionKey("TeamA").processVariableValueEquals("gender", "female").list();

            calculateProcesses.setMale(tasks.stream().count());
            calculateProcesses.setFemale(tasks2.stream().count());
        }
        if(team.equals("TeamB")){
            List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("TeamB").processVariableValueEquals("gender", "male").list();
            List<Task> tasks2 = taskService.createTaskQuery().processDefinitionKey("TeamB").processVariableValueEquals("gender", "female").list();

            calculateProcesses.setMale(tasks.stream().count());
            calculateProcesses.setFemale(tasks2.stream().count());
        }

        return new ResponseEntity<>(calculateProcesses.toString(), HttpStatus.OK);
    }
}
