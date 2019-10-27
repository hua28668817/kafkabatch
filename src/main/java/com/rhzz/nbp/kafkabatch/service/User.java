package com.rhzz.nbp.kafkabatch.service;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Integer id;
    private String userName;
    private String description;
    //@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
