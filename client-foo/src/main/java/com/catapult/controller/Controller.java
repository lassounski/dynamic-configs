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

    @Value("${account:Default}")
    private String account;

    @Value("${env:Default}")
    private String env;

    @Value("${common-var:Default}")
    private String common;

    @Value("${com.client.foo:Default}")
    private String specific;

    @RequestMapping(value = "/props", produces = "application/json")
    public Map message() {
        return ImmutableMap.builder()
                .put("Application",name)
                .put("Environment",env)
                .put("com.client.foo", specific)
                .put("Common-var", common)
                .put("Account",account).build();
    }
}
