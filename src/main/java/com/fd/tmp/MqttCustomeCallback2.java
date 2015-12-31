package com.fd.tmp;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by qasim on 1/1/16.
 */
@Configuration
public class MqttCustomeCallback2 implements MqttCallback{
    private MqttAsyncClient mqttAsyncClient;

    @PostConstruct
    public void setCallback() throws MqttException {
        mqttAsyncClient = MqttAsyncClientFactory.mqttAsyncClientSubscription("tcp://localhost:1883", java.util.UUID.randomUUID().toString(), Constant.K_TAXI, 2);
        mqttAsyncClient.setCallback(this);
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("hello driver.....");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
