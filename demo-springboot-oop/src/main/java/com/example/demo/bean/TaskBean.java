package com.example.demo.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Prototype scoped bean.
 */
@Component
@Scope("prototype")
@Slf4j
public class TaskBean {

    public TaskBean() {
        log.info("TaskBean created: {}", this.hashCode());
    }
}
