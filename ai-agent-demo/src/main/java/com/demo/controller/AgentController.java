
package com.demo.controller;

import com.demo.model.AgentRequest;
import com.demo.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/execute")
    public String execute(@RequestBody AgentRequest request) {
        return agentService.handleRequest(request);
    }
}
