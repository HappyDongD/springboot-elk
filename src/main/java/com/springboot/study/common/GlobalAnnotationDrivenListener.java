package com.springboot.study.common;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class GlobalAnnotationDrivenListener {



    @EventListener
    public void handleApplicationStarted(ApplicationStartedEvent ase) {
        System.out.println("项目启动成功!!!------>>>"+ase);
    }
}
