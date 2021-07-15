package com.example.workflow;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

public class StartProcess{

    //public ProcessEngine processEngines =  ProcessEngines.getDefaultProcessEngine();

    @Bean
    public void startService(String key){
        ProcessEngine processEngines =  ProcessEngines.getDefaultProcessEngine();

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("source", "api");
        processEngines.getRuntimeService().startProcessInstanceByKey(key, variables);
    }
}
