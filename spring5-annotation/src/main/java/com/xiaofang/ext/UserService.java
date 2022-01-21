package com.xiaofang.ext;

import com.xiaofang.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    Worker worker;


    @EventListener(classes = {ContextRefreshedEvent.class})
    public void listen() {
        println();
    }

    public void println() {
        System.out.println("++++++" + worker);
    }
}
