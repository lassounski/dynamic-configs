package com.catapult.controller;


import com.google.common.collect.ImmutableMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class Controller {

    @Value("${name}")
    private String name;

    @Value("${account}")
    private String account;

    @Value("${env}")
    private String env;

    @Value("${com.client.bar}")
    private String bar;

    @RequestMapping(value = "/props", produces = "application/json")
    public Map message() {
        return ImmutableMap.builder()
                .put("env",env)
                .put("name",name)
                .put("bar",bar)
                .put("account",account).build();
    }
}
