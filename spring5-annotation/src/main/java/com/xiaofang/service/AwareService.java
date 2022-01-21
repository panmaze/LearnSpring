package com.xiaofang.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringValueResolver;

@Service
public class AwareService implements ApplicationContextAware, BeanNameAware, EnvironmentAware, EmbeddedValueResolverAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc:" + applicationContext);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String resolveStringValue = resolver.resolveStringValue("你好 ${os.name} 我是#{20*18}");
        System.out.println("解析的字符串:" + resolveStringValue);

    }

    @Override
    public void setEnvironment(Environment environment) {
        String version = environment.getProperty("java.version");
        System.out.println("当前java版本:" + version);
    }
}
