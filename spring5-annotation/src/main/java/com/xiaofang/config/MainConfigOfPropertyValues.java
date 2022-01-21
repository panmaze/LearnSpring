package com.xiaofang.config;

import com.xiaofang.entity.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:/dog.properties"})
public class MainConfigOfPropertyValues {

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
