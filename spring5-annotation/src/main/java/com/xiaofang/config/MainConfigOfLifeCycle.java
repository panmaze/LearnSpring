package com.xiaofang.config;


import com.xiaofang.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


/**
 * bean的生命周期：<br>
 * bean创建---初始化----销毁的过程<br>
 * 容器管理bean的生命周期；<br>
 * 我们可以自定义初始化和销毁方法；容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * <p>
 * 构造（对象创建）<br>
 * 单实例：在容器启动的时候创建对象<br>
 * 多实例：在每次获取的时候创建对象<br>
 * <p>
 * BeanPostProcessor.postProcessBeforeInitialization<br>
 * 初始化：<br>
 * 对象创建完成，并赋值好，调用初始化方法<br>
 * BeanPostProcessor.postProcessAfterInitialization<br>
 * 销毁：<br>
 * 单实例：容器关闭的时候<br>
 * 多实例：容器不会管理这个bean；容器不会调用销毁方法；<br>
 * <p>
 * <p>
 * 遍历得到容器中所有的BeanPostProcessor；挨个执行beforeInitialization，
 * 一但返回null，跳出for循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 * <p>
 * BeanPostProcessor原理<br>
 * populateBean(beanName, mbd, instanceWrapper);给bean进行属性赋值
 * <pre>
 * initializeBean
 * {
 *   applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *   invokeInitMethods(beanName, wrappedBean, mbd);执行自定义初始化
 *   applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 * </pre>
 * (1).指定初始化和销毁方法；<br>
 * &emsp;&emsp;通过@Bean指定init-method和destroy-method；<br>
 * (2).通过让Bean实现InitializingBean(定义初始化逻辑),DisposableBean(定义销毁逻辑);<br>
 * (3).可以使用JSR250；<br>
 * &emsp;&emsp;PostConstruct：在bean创建完成并且属性赋值完成；来执行初始化方法<br>
 * &emsp;&emsp;PreDestroy：在容器销毁bean之前通知我们进行清理工作<br>
 * (4).BeanPostProcessor【interface】：bean的后置处理器；<br>
 * 在bean初始化前后进行一些处理工作；<br>
 * &emsp;&emsp;postProcessBeforeInitialization:在初始化之前工作<br>
 * &emsp;&emsp;postProcessAfterInitialization:在初始化之后工作<br>
 * Spring底层对 BeanPostProcessor 的使用；<br>
 * bean赋值，注入其他组件，@Autowired，生命周期注解功能，@Async,xxx BeanPostProcessor;
 */
@Configuration
@ComponentScan(value = "com.xiaofang.config", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyBeanPostProcessor.class})
}, useDefaultFilters = false)
public class MainConfigOfLifeCycle {

    //@Scope("prototype")
    @Bean(initMethod = "beanInit", destroyMethod = "beanDestroy")
    public Car car() {
        return new Car();
    }


}
