package com.gupaoedu.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Configuration
@ComponentScan("com.gupaoedu.example")
public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(Bootstrap.class);
    }
}
