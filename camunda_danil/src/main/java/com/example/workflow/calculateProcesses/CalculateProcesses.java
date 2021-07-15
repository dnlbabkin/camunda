package com.example.workflow.calculateProcesses;

import com.example.workflow.jsonMap.MappingJson;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class CalculateProcesses {

    private long male;
    private long female;

    public long getMale(long count) {
        return male;
    }

    public void setMale(long male) {
        this.male = male;
    }

    public long getFemale(long count) {
        return female;
    }

    public void setFemale(long female) {
        this.female = female;
    }

    @Bean
    public void startCalc(String key){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        processEngine.getRuntimeService().startProcessInstanceByKey(key);
    }

    @Override
    public String toString() {
        return "CalculateProcesses{" +
                "male='" + male + '\'' +
                ", female='" + female + '\'' +
                '}';
    }
}
