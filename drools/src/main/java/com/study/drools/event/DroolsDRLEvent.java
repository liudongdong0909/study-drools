package com.study.drools.event;

import org.springframework.context.ApplicationEvent;

public class DroolsDRLEvent extends ApplicationEvent {

    public DroolsDRLEvent(Object source) {
        super(source);
    }
}
