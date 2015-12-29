package com.fd.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qasim on 29/12/15.
 */
@Configuration
public class MqttConfiguration {
    @Bean
    public MqttTemplate mqttTemplate() throws MqttException {
        MqttTemplate mqttTemplate = new MqttTemplate(Constants.FD_MQTT_SERVER_URL);
        mqttTemplate.connect(MqttTemplate.defaultOptions());
        System.out.println("Mqtt connected with mqtt broker at url : localhost:1883");
        return mqttTemplate;
    }
}
