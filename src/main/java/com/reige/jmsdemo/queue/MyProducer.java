package com.reige.jmsdemo.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by REIGE on 2017/10/7.
 */
public class MyProducer {
    private static final String url = "tcp://127.0.0.1:61616";
    private static final String queueName = "queue-demo";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //创建会话
        // 1.是否在事务中处理  2.连接的应答模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//自动应答
        //创建目的地
        Destination destination = session.createQueue(queueName);
        //创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 10; i++) {
            TextMessage textMessage = session.createTextMessage("发送消息--" + i);
            producer.send(textMessage);
            System.out.println("发送消息--" + i);
        }
        //关闭连接
        connection.close();
    }

}
