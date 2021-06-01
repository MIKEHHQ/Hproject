package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String userCode;

    private String name;

    private Boolean sex;

    private Boolean enabled;

    private String password;

    private String department;

    private String phone;

    private String email;

    private String createdBy;

    private String updatedBy;

    private Date createdAt;

    private Date updatedAt;
}