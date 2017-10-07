package com.reige.jmsdemo.springtest.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by REIGE on 2017/10/7.
 */
public class MyProducer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service = context.getBean(ProducerService.class);
        for (int i = 0; i < 10; i++) {
            service.sendMessage("这是第" + i + "条消息");
        }
        context.close();
    }
}
