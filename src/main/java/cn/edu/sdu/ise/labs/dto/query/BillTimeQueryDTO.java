package cn.edu.sdu.ise.labs.dto.query;

import lombok.Data;

import java.util.Date;

@Data
public class BillTimeQueryDTO extends PageQueryDTO {
    private Date startDate;
    private Date endDate;
}
