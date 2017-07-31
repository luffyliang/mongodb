package com.mon.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mon.pojo.UserEntity;
import com.mon.service.receiveService;


@Component
public class Receiver {
    @Autowired
    receiveService receiveService;
    private Gson gson = new GsonBuilder().create();
   
    @KafkaListener(topics = "test")
    public void processMessage(String content) {
       receiveService.receive(content);
    }
}
