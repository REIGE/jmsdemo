package com.reige.jmsdemo.springtest.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by REIGE on 2017/10/7.
 */
public class ConsumerMessageListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(("接收消息" + textMessage.getText()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
