package com.greenfox.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by almasics on 2017.01.20..
 */
@RestController
public class HelloController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @RequestMapping(value = "/hello")
    public String hello() {
        stateMachine.sendEvent(Events.E1);
        return "Hello";
    }
}
