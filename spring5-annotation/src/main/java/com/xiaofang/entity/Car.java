package com.xiaofang.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Car implements InitializingBean, DisposableBean {

    public Car() {
        System.out.println("car constructor...");
    }

    public void beanInit() {
        System.out.println("car @Bean init...");
    }

    public void beanDestroy() {
        System.out.println("car @Bean destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car InitializingBean afterPropertiesSet...");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("car DisposableBean destroy...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("car postConstruct init...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("car preDestroy destroy...");
    }
}
