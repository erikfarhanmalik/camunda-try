package com.erik.learn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class RequestToProcessMapping {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long requestId;
    private String processInstanceId;

    public RequestToProcessMapping(Long requestId, String processInstanceId) {
        this.requestId = requestId;
        this.processInstanceId = processInstanceId;
    }
}
