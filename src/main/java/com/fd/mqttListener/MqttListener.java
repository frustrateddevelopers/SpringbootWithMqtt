package com.fd.mqttListener;

import com.fd.mqtt.Constants;
import com.fd.mqtt.MqttTemplate;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by qasim on 30/12/15.
 */
@Configuration
public class MqttListener implements MqttCallback{

    @Autowired
    MqttTemplate mqttTemplate;

    @PostConstruct
    public void initialize() throws MqttException {
        mqttTemplate.subscribe(Constants.FD_MQTT_TOPIC);
        mqttTemplate.setCallback(this);
    }

    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(s+" : "+mqttMessage.toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
