package com.xiaofang.config;

import com.xiaofang.entity.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xiaofang.ext")
public class MainConfigOfExt {

    @Bean
    public Worker worker(){
        return new Worker();
    }


}
