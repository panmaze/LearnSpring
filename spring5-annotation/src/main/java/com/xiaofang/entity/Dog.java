package com.xiaofang.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Dog {
    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）

    @Value("BH123")
    private String id;

    @Value("#{18-12}")

    private Integer age;

    @Value("${os.name}")
    private String name;

    @Value("${address}")
    private String address;
}
