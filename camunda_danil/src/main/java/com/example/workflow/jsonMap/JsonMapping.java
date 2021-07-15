package com.example.workflow.jsonMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;

public class JsonMapping implements JavaDelegate {

    public Map<String, String> env = System.getenv();

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        MappingJson mappingJson = objectMapper.readValue(getJSON(), MappingJson.class);

        execution.setVariable("firstName", mappingJson.getResults().getName().getFirst());
        execution.setVariable("lastName", mappingJson.getResults().getName().getLast());
        execution.setVariable("gender", mappingJson.getResults().getGender());
    }


    public String getJSON() {
        String url = env.get("RANDOM_PERSONS");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        final String response = restTemplate.getForObject(url, String.class);

        return response;
    }
}
