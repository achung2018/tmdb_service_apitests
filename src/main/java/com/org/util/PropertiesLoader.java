package com.org.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"com.org"} )
@PropertySources({
        @PropertySource("classpath:default.properties"),
        @PropertySource(value = "classpath:environments/${environment}.properties", ignoreResourceNotFound = true) })
public class PropertiesLoader {

    public static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(PropertiesLoader.class);

    @Bean
    public PropertiesBean getPropertiesBean() {
        return new PropertiesBean();
    }

    public static String getBasePath() {
        return context.getBean(PropertiesBean.class).getBaseEndPoint();
    }

    public static String getApiPath(String api) {
        return context.getBean(PropertiesBean.class).getApiPath(api);
    }


    public class PropertiesBean {
        @Autowired
        Environment env;

        public String getBaseEndPoint () {
            return env.getProperty("service.baseurl");
        }

        public String getApiPath(String key) {
            return env.getProperty(key);
        }
    }
}
