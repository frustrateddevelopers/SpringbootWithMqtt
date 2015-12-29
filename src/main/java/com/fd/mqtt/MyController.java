package com.fd.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qasim on 29/12/15.
 */

@RestController
@RequestMapping("/api/test")
public class MyController {

    @Autowired
    MqttTemplate mqttTemplate;

    @RequestMapping("/service")
    public String testService() throws MqttException {
        String mqttMsg = "sending test data on mqtt server...";
        MqttMessage message = new MqttMessage(mqttMsg.getBytes());
        message.setQos(Constants.FD_MQTT_QOS);
        message.setRetained(true);
        mqttTemplate.publish(Constants.FD_MQTT_TOPIC, message);
        return "success";
    }
}
