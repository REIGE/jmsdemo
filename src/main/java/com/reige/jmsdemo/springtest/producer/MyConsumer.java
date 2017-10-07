package com.reige.jmsdemo.springtest.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by REIGE on 2017/10/7.
 */
public class MyConsumer {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    }
}
