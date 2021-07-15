package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class StartProcessDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        try {
            if (execution.getVariable("source").equals("api")) {
                execution.setVariable("source", "api");
            }
        } catch (Exception e){
                execution.setVariable("source", "adminka");
        }
    }
}
