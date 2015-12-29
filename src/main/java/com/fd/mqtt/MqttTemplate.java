package com.fd.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qasim on 29/12/15.
 */
public class MqttTemplate extends MqttClient {

    public MqttTemplate(String serverURI) throws MqttException {
        super(serverURI, java.util.UUID.randomUUID().toString());
    }

    public static MqttConnectOptions defaultOptions(){
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(true);
        return mqttConnectOptions;
    }
}
