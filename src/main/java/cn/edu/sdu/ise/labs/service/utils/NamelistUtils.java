package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dto.NamelistDTO;
import cn.edu.sdu.ise.labs.model.Namelist;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.NamelistVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

/**
 * @author 15508
 */
public class NamelistUtils {
    /**
     * 规范并校验namelistDTO
     *
     * @param namelistDTO
     */
    public static void validateNamelist(NamelistDTO namelistDTO) {
        FormatUtils.trimFieldToNull(namelistDTO);
        Assert.notNull(namelistDTO, "联系人输入数据不能为空");
        Assert.hasText(namelistDTO.getName(), "部门名称不能为空");
    }

    /**
     * 奖实体对象转化为VO对象
     *
     * @param namelist 实体对象
     * @return VO对象
     */
    public static NamelistVO convertToVO(Namelist namelist) {
        NamelistVO namelistVO = new NamelistVO();
        BeanUtils.copyProperties(namelist, namelistVO);
        return namelistVO;

    }
}
