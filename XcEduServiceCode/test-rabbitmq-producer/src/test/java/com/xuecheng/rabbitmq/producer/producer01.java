package com.xuecheng.rabbitmq.producer;

import com.rabbitmq.client.ConnectionFactory;

public class producer01 {
    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
    }
}
