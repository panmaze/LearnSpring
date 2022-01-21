package com.xiaofang.ioc;

import com.xiaofang.config.MainConfigOfAutowired;
import com.xiaofang.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test04_Autowired {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("++++++++++");
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);
    }
}
