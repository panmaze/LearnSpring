package com.xiaofang.ioc;

import com.xiaofang.config.MainConfigOfPropertyValues;
import com.xiaofang.entity.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test03_PropertyValues {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
        Dog dog = applicationContext.getBean(Dog.class);
        System.out.println(dog);
    }
}
