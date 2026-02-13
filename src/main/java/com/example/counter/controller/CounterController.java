package com.example.counter.controller;

import com.example.counter.service.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CounterController {
    private final CounterService counterService;

    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @GetMapping("/count")
    public Map<String, Object> getCount() throws Exception {
        String hostname = InetAddress.getLocalHost().getHostName();

        Map<String, Object> response = new HashMap<>();
        response.put("count", counterService.getCount()); // 카운트 정보
        response.put("server", hostname); // 서버 정보
        return response;
    }

    @PostMapping("/count/increment")
    public Map<String, Object> increment() throws Exception {
        String hostname = InetAddress.getLocalHost().getHostName();
        Long newCount = counterService.increment();

        Map<String, Object> response = new HashMap<>();
        response.put("count", newCount); // 카운트 정보
        response.put("server", hostname); // 서버 정보
        response.put("message", "카운트 증가!");
        return response;
    }

    @GetMapping("/info")
    public Map<String, String> getInfo() throws Exception {
        String hostname = InetAddress.getLocalHost().getHostName();
        String ip = InetAddress.getLocalHost().getHostAddress();

        Map<String, String> response = new HashMap<>();
        response.put("hostname", hostname); // 카운트 정보
        response.put("IP", ip); // 서버 정보
        return response;
    }
}
