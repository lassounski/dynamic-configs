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

    @Value("${name:Default}")
    private String name;

    @Value("${env:Default}")
    private String env;

    @Value("${common-var:Default}")
    private String common;

    @Value("${com.client.bar:Default}")
    private String specific;

    @Value("${account:Default}")
    private int account;

    @RequestMapping(value = "/props", produces = "application/json")
    public Map message() {
        return ImmutableMap.builder()
                .put("Application",name)
                .put("Environment",env)
                .put("com.client.bar", specific)
                .put("Common-var", common)
                .put("Account",account).build();
    }
}
