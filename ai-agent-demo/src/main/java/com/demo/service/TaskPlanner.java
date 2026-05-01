
package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskPlanner {

    @Autowired
    private LlmService llmService;

    public List<String> splitTask(String input) {
        String res = llmService.call("拆分任务：" + input);
        return Arrays.asList(res.split("\n"));
    }
}
