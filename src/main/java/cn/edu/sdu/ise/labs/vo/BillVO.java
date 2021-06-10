package cn.edu.sdu.ise.labs.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author HHQ
 */
@Data
public class BillVO {
    private Integer id;

    private String purpose;

    private Double amount;

    private Date consumeTime;

    private String consumer;

    private String note;

    private String createdAt;

    private String updatedAt;

    private String updatedBy;

    private String createdBy;
}
