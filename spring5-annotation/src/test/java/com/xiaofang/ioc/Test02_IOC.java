package com.xiaofang.ioc;

import com.xiaofang.config.MainConfig1;
import com.xiaofang.config.MainConfig2;
import com.xiaofang.entity.Person;
import com.xiaofang.entity.White;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test02_IOC {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig1.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("ioc容器创建完成");
        Person person1 = applicationContext.getBean(Person.class);
        Person person2 = applicationContext.getBean(Person.class);
        System.out.println(person1 == person2);
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("ioc容器创建完成");
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void test04() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test05() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test06() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("++++++++++++++");
        Object whiteFactoryBean1 = applicationContext.getBean("whiteFactoryBean");
        Object whiteFactoryBean2 = applicationContext.getBean("whiteFactoryBean");
        System.out.println("bean的类型:" + whiteFactoryBean1.getClass());
        System.out.println(whiteFactoryBean1 == whiteFactoryBean2);
        ((White)whiteFactoryBean1).print();

        Object bean = applicationContext.getBean("&whiteFactoryBean");
        System.out.println(bean.getClass());
    }
}
