package com.rhzz.nbp.kafkabatch.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Component
public class UserTask {

    @Value("#{'${kafka.listener.topics}'.split(',')}")
    private List<String> topics;

    private final MultiService MUlTI_SERVICE;

    private final KafkaSender KAFKA_SENDER;

    @Autowired
    public UserTask(MultiService multiService, KafkaSender kafkaSender){
        this.MUlTI_SERVICE = multiService;
        this.KAFKA_SENDER = kafkaSender;
    }

    @Scheduled(fixedRate = 1 * 1000)
    public void addUserTask() {
        User user=new User();
        user.setUserName("HS");
        user.setDescription("text");
        user.setCreateTime(LocalDateTime.now());

        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);

        for (int i = 0; i < 700; i++) {
            KAFKA_SENDER.sendMessage(topics.get(0), jsonUser);
            //jjjjjj11111
            //kk22222
            //fff
            //ggg
            //kafka demo 222 modify
            //kafka modify by master branch
            
        }
    //    MUlTI_SERVICE.addUser(user);
    }

}
