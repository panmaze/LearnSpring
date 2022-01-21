package com.xiaofang.condition;

import com.xiaofang.entity.Green;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        boolean definition1 = registry.containsBeanDefinition("com.xiaofang.entity.Red");
        boolean definition2 = registry.containsBeanDefinition("com.xiaofang.entity.Blue");
        if (definition1 && definition2) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Green.class);
            registry.registerBeanDefinition("green", beanDefinition);
        }
    }
}
