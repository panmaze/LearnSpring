package com.xiaofang.config;

import com.xiaofang.entity.DBConfig;
import com.xiaofang.entity.Worker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

//@Profile("test")
@Configuration
@PropertySource("classpath:/dbconfig.properties")
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user")
    private String user;

    private String driver;

    @Bean
    public Worker worker() {
        return new Worker();
    }

    @Profile("test")
    @Bean("testDB")
    public DBConfig testDbConfig(@Value("${db.password}") String password){
        DBConfig dbConfig = new DBConfig();
        dbConfig.setUser(user);
        dbConfig.setPassword(password);
        dbConfig.setUrl("jdbc:mysql://localhost:3306/test");
        dbConfig.setDriver(driver);
        return dbConfig;
    }

    @Profile("dev")
    @Bean("devDb")
    public DBConfig devDbConfig(@Value("${db.password}") String password){
        DBConfig dbConfig = new DBConfig();
        dbConfig.setUser(user);
        dbConfig.setPassword(password);
        dbConfig.setUrl("jdbc:mysql://localhost:3306/dev");
        dbConfig.setDriver(driver);
        return dbConfig;
    }


    @Profile("prod")
    @Bean("prodDB")
    public DBConfig prodDbConfig(@Value("${db.password}") String password){
        DBConfig dbConfig = new DBConfig();
        dbConfig.setUser(user);
        dbConfig.setPassword(password);
        dbConfig.setUrl("jdbc:mysql://localhost:3306/prod");
        dbConfig.setDriver(driver);
        return dbConfig;
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        driver = resolver.resolveStringValue("${db.driver");
    }
}
