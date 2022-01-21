package com.xiaofang.ioc;

import com.xiaofang.config.MainConfigOfExt;
import com.xiaofang.ext.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test07_Ext {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfExt.class);
       // Worker worker = applicationContext.getBean(Worker.class);
        //System.out.println(worker);
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfExt.class);
        applicationContext.publishEvent(new ApplicationEvent("我发布的事件") {
        });
        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println("++++++++++" + userService);
        applicationContext.close();
    }
}
