package com;

import com.filter.SessionFilter;
import com.servlet.ImportExcelServlet;
import com.servlet.InitServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@EnableAutoConfiguration(exclude={
        JpaRepositoriesAutoConfiguration.class//禁止springboot自动加载持久化bean
})
@MapperScan("com.logisticsecnter.mapper")
public class LogisticsCenterApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(LogisticsCenterApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(LogisticsCenterApplication.class, args);
    }
    @Bean
    public FilterRegistrationBean authFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new SessionFilter());
        registration.addUrlPatterns("/api/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public ServletRegistrationBean authServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new InitServlet());
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("initServlet");
        return registration;
    }

    @Bean
    public ServletRegistrationBean importServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ImportExcelServlet());
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("importExcelServlet");
        return registration;
    }

    @Override
    public void run(String... var1) throws Exception {
        InitServlet startUpServlet = new InitServlet();
        startUpServlet.init(startUpServlet.getServletConfig());
    }
}
