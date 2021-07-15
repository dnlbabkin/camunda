package com.example.workflow.callProcess;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.springframework.context.annotation.Bean;

public class CallProcess {

    @Bean
    public void callProcessesA(String keyA){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRuntimeService().startProcessInstanceByKey(keyA);
    }

    @Bean
    public void callProcessesB(String keyB){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getRuntimeService().startProcessInstanceByKey(keyB);
    }
}
