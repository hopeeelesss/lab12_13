package com.example.lab13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.beans.BeanProperty;

@Configuration
@ComponentScan("com.example.lab13")
@PropertySource("classpath:application.yml")
public class Lab13Application {


}
