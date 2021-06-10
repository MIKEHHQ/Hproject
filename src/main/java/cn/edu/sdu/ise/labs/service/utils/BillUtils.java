package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dto.BillDTO;
import cn.edu.sdu.ise.labs.model.Bill;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.BillVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

/**
 * @author HHQ
 * @description
 */
public class BillUtils {
    /**
     * 规范并校验billDTO
     *
     * @param billDTO
     */
    public static void validateBill(BillDTO billDTO) {
        FormatUtils.trimFieldToNull(billDTO);
        Assert.notNull(billDTO, "部门输入数据不能为空");
        Assert.hasText(billDTO.getConsumer(), "部门名称不能为空");
    }

    /**
     * 将实体对象转换为VO对象
     *
     * @param bill
     * @return VO对象
     */
    public static BillVO convertToVO(Bill bill) {
        BillVO billVO = new BillVO();
        BeanUtils.copyProperties(bill, billVO);
        billVO.setCreatedAt(FormatUtils.formatFullDate(bill.getCreatedAt()));
        billVO.setUpdatedAt(FormatUtils.formatFullDate(bill.getUpdatedAt()));
        return billVO;
    }
}
