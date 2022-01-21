package com.xiaofang.config;

import com.xiaofang.entity.White;
import org.springframework.beans.factory.FactoryBean;

public class WhiteFactoryBean implements FactoryBean<White> {

    public WhiteFactoryBean() {
        System.out.println("WhiteFactoryBean construct..");
    }

    @Override
    public White getObject() throws Exception {
        System.out.println("WhiteFactoryBean getObject...");
        return new White();
    }

    @Override
    public Class<?> getObjectType() {
        return White.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
