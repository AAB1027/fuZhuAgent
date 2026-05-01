
package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private TaskPlanner taskPlanner;

    @Autowired
    private LlmService llmService;

    public String handleRequest(com.demo.model.AgentRequest request) {

        switch (request.getType()) {
            case "code":
                return llmService.call("生成Java代码：" + request.getInput());
            case "sql":
                return llmService.call("生成SQL：" + request.getInput());
            case "log":
                return llmService.call("分析日志：" + request.getInput());
            case "full":
                return handleComplex(request.getInput());
            default:
                return "unsupported";
        }
    }

    private String handleComplex(String input) {
        List<String> tasks = taskPlanner.splitTask(input);
        StringBuilder sb = new StringBuilder();
        for (String t : tasks) {
            sb.append(llmService.call(t)).append("\n\n");
        }
        return sb.toString();
    }
}
