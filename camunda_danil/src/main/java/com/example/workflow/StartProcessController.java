package com.example.workflow;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@RequestMapping("camunda/rest-api/startProcess")
@RestController
public class StartProcessController {
    StartProcess startProcess = new StartProcess();

//    @RequestMapping(value = "/{key}", method = RequestMethod.GET, produces = "application/json")
//    public @ResponseBody
//    StartProcess getProcess(@PathVariable String key){
//        startProcess.startService(key);
//        return startProcess;
//    }

    @GetMapping(value = "/camunda/rest-api/startProcess/{key}", produces = "application/json")
    public ResponseEntity<?> startService(@PathVariable String key){
        startProcess.startService(key);

        return new ResponseEntity<>(startProcess.toString(), HttpStatus.CREATED);
    }
}
