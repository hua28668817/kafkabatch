package com.rhzz.nbp.kafkabatch.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class KafkaListeners {


    @KafkaListener(containerFactory = "kafkaBatchListener6",topics = {"#{'${kafka.listener.topics}'.split(',')[0]}"})
    public void batchListener(List<ConsumerRecord<?,?>> records, Acknowledgment ack){

        List<User> userList = new ArrayList<>();
        try {
            records.forEach(record -> {
                Gson gson = new Gson();
                User user = gson.fromJson(record.value().toString(), User.class);

                //user.getCreateTime().format(DateTimeFormatter.ofPattern(Contants.DateTimeFormat.DATE_TIME_PATTERN));
                userList.add(user);
            });
        } catch (Exception e) {
            log.error("Kafka监听异常"+e.getMessage(),e);
        } finally {
            ack.acknowledge();//手动提交偏移量
        }

    }

}
