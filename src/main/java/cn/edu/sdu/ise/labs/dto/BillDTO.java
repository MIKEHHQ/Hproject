package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author HHQ
 */
@Data
public class BillDTO {
    private Integer id;

    private String purpose;

    private Double amount;

    private Date consumeTime;

    private String consumer;

    private String note;
}
