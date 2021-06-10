package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.BillDTO;
import cn.edu.sdu.ise.labs.dto.query.BillQueryDTO;
import cn.edu.sdu.ise.labs.dto.query.BillTimeQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.vo.BillVO;

import java.util.List;

/**
 * 部门模块服务接口
 *
 * @author HHQ
 * @date 2019-12-3
 */
public interface BillService {
    Page<BillVO> listByPage(BillQueryDTO queryDTO);

    /**
     * 新建部门
     *
     * @param billDTO 部门输入对象
     * @return 部门编码
     */
    Integer addBill(BillDTO billDTO);
    /**
     * 更新部门数据
     *
     * @param billDTO 部门输入对象
     * @return 部门编码
     */
    Integer updateBill(BillDTO billDTO);
    /**
     * 根据编码列表，批量删除部门
     *
     * @param ids 编码列表
     */
    void deleteByCodes(List<Integer> ids);

    Page<BillVO> listByTime(BillTimeQueryDTO queryDTO);
}
