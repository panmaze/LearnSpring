package com.xiaofang.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        int count = beanFactory.getBeanDefinitionCount();
        System.out.println("当前BeanFactory中有" + count + "个bean");
        String[] names = beanFactory.getBeanDefinitionNames();
        System.out.println("当前BeanFactory名称分别:" + Arrays.toString(names));

    }
}
