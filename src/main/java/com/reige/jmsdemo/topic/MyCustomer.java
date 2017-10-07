package com.reige.jmsdemo.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by REIGE on 2017/10/7.
 */
public class MyCustomer {
    private static final String url = "tcp://127.0.0.1:61616";
    private static final String topicName = "topic-demo";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //创建会话
        // 1.是否在事务中处理  2.连接的应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//自动应答
        //创建目的地
        Destination destination = session.createTopic(topicName);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);

        //创建监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(("topic接收:" + textMessage.getText()));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
