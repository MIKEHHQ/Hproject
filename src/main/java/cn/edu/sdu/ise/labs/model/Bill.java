package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.Date;

@Data
public class Bill {
    private Integer id;

    private String purpose;

    private Double amount;

    private Date consumeTime;

    private String consumer;

    private String note;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

}