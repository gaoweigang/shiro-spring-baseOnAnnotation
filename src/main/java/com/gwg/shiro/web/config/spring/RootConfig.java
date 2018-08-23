package com.gwg.shiro.web.config.spring;

import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring配置
 * 该配置文件中配置bean在Spring的容器中
 */
@Configuration
@ComponentScan(basePackages={"com.gwg"}, excludeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value=EnableWebMvc.class),
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value=RestController.class),//排除SpringMVC的
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value=Controller.class)
})
public class RootConfig {

    /**
     * 加载配置文件
     * @return
     */
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        ClassPathResource resource = new ClassPathResource("config.properties");
        propertyPlaceholderConfigurer.setLocation(resource);
        return propertyPlaceholderConfigurer;
    }

}