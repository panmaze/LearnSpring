package com.xiaofang.ioc;

import com.xiaofang.config.MainConfigOfLifeCycle;
import com.xiaofang.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test03_LifeOfCycle {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
      /*  System.out.println("++++++++++++++");
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("++++++++++++++");*/
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);
        applicationContext.close();
    }
}
