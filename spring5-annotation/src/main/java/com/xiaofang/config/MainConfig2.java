package com.xiaofang.config;

import com.xiaofang.condition.LinuxCondition;
import com.xiaofang.condition.MyImportBeanDefinitionRegistrar;
import com.xiaofang.condition.MyImportSelector;
import com.xiaofang.condition.WindowsCondition;
import com.xiaofang.entity.Person;
import com.xiaofang.entity.Pink;
import com.xiaofang.entity.Red;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

@Configuration
@Import(value = {Pink.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /**
     * 默认是单实例的
     * <p>
     * {@link ConfigurableBeanFactory#SCOPE_SINGLETON}<br>
     * {@link ConfigurableBeanFactory#SCOPE_PROTOTYPE}
     * <p>
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 每次获取的时候才会调用方法创建对象；
     * <p>singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 以后每次获取就是直接从容器（map.get()）中拿，
     * <p>request：同一次请求创建一个实例
     * <p>session：同一个session创建一个实例
     * <p>
     * 懒加载：
     * 单实例bean：默认在容器启动的时候创建对象；
     * 懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     */
    // @Scope("prototype")
    @Bean
    @Lazy
    public Person person() {
        System.out.println("给容器添加Person bean...");
        Person person = new Person();
        person.setId(19);
        person.setName("David");
        return person;
    }

    /**
     * Conditional: 按照一定的条件进行判断，满足条件给容器中注册bean
     * <p>
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person bill() {
        Person person = new Person();
        person.setId(62);
        person.setName("Bill Gates");
        return person;
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")//-Dos.name=linux
    public Person linus() {
        Person person = new Person();
        person.setId(48);
        person.setName("linus");
        return person;
    }

    /**
     * 给容器中注册组件的方式；<br>
     * (1).包扫描+组件标注注解(@Controller/@Service/@Repository/@Component)[自己写的类]<br>
     * (2).@Bean[导入的第三方包里面的组件]<br>
     * (3).@Import[快速给容器中导入一个组件]<br>
     * &emsp; Ⅰ.@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名<br>
     * &emsp; Ⅳ.ImportSelector:返回需要导入的组件的全类名数组；<br>
     * &emsp; Ⅶ.ImportBeanDefinitionRegistrar:手动注册bean到容器中<br>
     * (4).使用Spring提供的 FactoryBean（工厂Bean）;<br>
     * &emsp;Ⅰ.默认获取到的是工厂bean调用getObject创建的对象<br>
     * &emsp;Ⅳ.要获取工厂Bean本身，我们需要给id前面加一个&<br>
     * &whiteFactoryBean
     */
    @Bean
    public WhiteFactoryBean whiteFactoryBean() {
        return new WhiteFactoryBean();
    }
}
