package com.example.demo.controller;

import com.example.demo.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class RedisData {

    private final RedisService redisService;

    @Autowired
    public RedisData(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping(value="/cache", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<String> searchRedis(@RequestParam String pattern) {
        return redisService.findBetsByKeyPattern(pattern);
    }

}
