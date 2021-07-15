package com.example.workflow.callProcess;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CallProcessesController {
    CallProcess callProcess = new CallProcess();

    private Map<String, String> env = System.getenv();

    @PostMapping(value = "${START_PROCESSES}", produces = "application/json")
    public ResponseEntity<?> createProcesses(){

        for(int i = 0; i < 50; i++) {
            callProcess.callProcessesA("TeamA");
            callProcess.callProcessesA("TeamB");
        }

        return new ResponseEntity<>(callProcess.toString(), HttpStatus.CREATED);
    }
}
