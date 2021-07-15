package com.example.workflow.fuckUp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FUPController {
    TasksIDFUP tasksIDFUP = new TasksIDFUP();
    ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping(value = "/camunda/rest-api/task", produces = "application/json")
    public ResponseEntity<?> fupMethod(@RequestBody String definitionKey){

        try {
            ParserFUP fup = objectMapper.readValue(definitionKey, ParserFUP.class);
            tasksIDFUP.runTask(fup.getDefinition_keys());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(tasksIDFUP.toString(), HttpStatus.OK);
    }

}
