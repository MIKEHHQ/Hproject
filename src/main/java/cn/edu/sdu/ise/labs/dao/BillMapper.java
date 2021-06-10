package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.query.BillQueryDTO;
import cn.edu.sdu.ise.labs.dto.query.BillTimeQueryDTO;
import cn.edu.sdu.ise.labs.model.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BillMapper {
    Bill selectByPrimaryKey(Integer id);

    /**
     * 新增记录
     *
     * @param record
     * @return
     */
    int insert(Bill record);

    /**
     * 根据主键更新记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Bill record);

    /**
     * 根据部门编码获取部门信息详情
     *
     * @param billCode 部门编码
     * @param tenantCode     租户代码
     * @return 门信息详情
     */
    Bill getByCode(
            @Param("billCode") String billCode,
            @Param("tenantCode") String tenantCode);


    /**
     * 根据查询条件获取命中个数
     *
     * @param queryDTO 查询条件
     * @return 命中数量
     */
    Integer count(BillQueryDTO queryDTO);

    /**
     * 根据查询条件获取部门列表
     *
     * @param queryDTO 查询条件
     * @param offset   开始位置
     * @param limit    记录数量
     * @return 部门列表
     */
    List<Bill> list(BillQueryDTO queryDTO, Integer offset, Integer limit
    );

    /**
     * 根据代码列表批量删除部门
     *
     * @param ids id列表
     */
    void deleteByCodes(@Param("codeList") List<Integer> ids);

    /**
     * 根据部门代码列表获取部门信息列表
     *
     * @param codeList   部门代码列表
     * @param tenantCode 租户代码
     * @return 部门列表
     */
    List<Bill> listByCodes(
            @Param("codeList") List<String> codeList,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据部门名称查询部门列表
     *
     * @param consumer 部门名称，模糊匹配
     * @param tenantCode     租户代码
     * @return 部门列表
     */
    List<Bill> listByName(
            @Param("consumer") String consumer,
            @Param("tenantCode") String tenantCode);

    /**
     * 根据查询条件获取命中个数
     *
     * @param queryDTO 查询条件
     * @return 命中数量
     */
    Integer countTime(BillTimeQueryDTO queryDTO);

    Double listByMonthSum(BillQueryDTO queryDTO);

    Double listByMonthConsume(BillQueryDTO queryDTO);
    /**
     * 根据查询条件获取部门列表
     *
     * @param queryDTO 查询条件
     * @param offset   开始位置
     * @param limit    记录数量
     * @return 部门列表
     */
    List<Bill> listByTime(BillTimeQueryDTO queryDTO, Integer offset, Integer limit);

    List<Bill> listByTime(BillTimeQueryDTO queryDTO, Date startDate, Date endDate, Integer offset, Integer limit);
}