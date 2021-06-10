package cn.edu.sdu.ise.labs.service.impl;


import cn.edu.sdu.ise.labs.dao.BillMapper;
import cn.edu.sdu.ise.labs.dto.BillDTO;
import cn.edu.sdu.ise.labs.dto.query.BillQueryDTO;

import cn.edu.sdu.ise.labs.dto.query.BillTimeQueryDTO;
import cn.edu.sdu.ise.labs.model.Bill;

import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Token;
import cn.edu.sdu.ise.labs.service.BillService;
import cn.edu.sdu.ise.labs.service.utils.BillUtils;

import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.utils.PageUtils;
import cn.edu.sdu.ise.labs.utils.TokenContextHolder;
import cn.edu.sdu.ise.labs.vo.BillVO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HHQ
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;

    @Override
    public Page<BillVO> listByPage(BillQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new BillQueryDTO();
        }

        queryDTO.setConsumer(FormatUtils.makeFuzzySearchTerm(queryDTO.getConsumer()));
        Token token = TokenContextHolder.getToken();

        Integer size = billMapper.count(queryDTO);
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), size);
        Page<BillVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(), pageUtils.getTotal(), new ArrayList<>());
        if (size == 0) {
            // 没有命中，则返回空数据。
            return pageData;
        }

        List<Bill> list = billMapper.list(queryDTO, pageUtils.getOffset(), pageUtils.getLimit());
        for (Bill bill : list) {
            pageData.getList().add(BillUtils.convertToVO(bill));
        }

        return pageData;
    }


    @Override
    public Integer addBill(BillDTO billDTO) {
        Token token = TokenContextHolder.getToken();
        BillUtils.validateBill(billDTO);
        Bill bill = new Bill();
        BeanUtils.copyProperties(billDTO, bill);
        bill.setCreatedBy(token.getUserCode());
        bill.setUpdatedBy(token.getUserCode());
        billMapper.insert(bill);
        return bill.getId();
    }

    @Override
    public Integer updateBill(BillDTO billDTO) {
        // 校验输入数据正确性
        Token token = TokenContextHolder.getToken();
        BillUtils.validateBill(billDTO);
        Assert.notNull(billDTO.getId(), "部门id不能为空");
        Bill bill = billMapper.selectByPrimaryKey(billDTO.getId());
        Assert.notNull(bill, "没有找到部门，Id为：" + billDTO.getId());

        BeanUtils.copyProperties(billDTO, bill);
        bill.setUpdatedBy(token.getUserCode());
        billMapper.updateByPrimaryKey(bill);
        return bill.getId();
    }

    @Override
    public void deleteByCodes(List<Integer> ids) {
        Assert.notEmpty(ids, "部门id列表不能为空");
        billMapper.deleteByCodes(ids);
    }
    @Override
    public Page<BillVO> listByTime(BillTimeQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new BillTimeQueryDTO();
        }

        queryDTO.setStartDate(FormatUtils.parseDateTime(FormatUtils.makeFuzzySearchTerm
                (FormatUtils.formatFullDate(queryDTO.getStartDate()))));
        queryDTO.setEndDate(FormatUtils.parseDateTime(FormatUtils.makeFuzzySearchTerm
                (FormatUtils.formatFullDate(queryDTO.getEndDate()))));

        Token token = TokenContextHolder.getToken();

        Integer size = billMapper.countTime(queryDTO);
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), size);
        Page<BillVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(),
                pageUtils.getTotal(), new ArrayList<>());
        if (size == 0) {
            // 没有命中，则返回空数据。
            return pageData;
        }

        List<Bill> list = billMapper.listByTime(queryDTO,pageUtils.getStartDate(),
                pageUtils.getEndDate(), pageUtils.getOffset(), pageUtils.getLimit());
        for (Bill bill : list) {
            pageData.getList().add(BillUtils.convertToVO(bill));
        }

        return pageData;
    }
}
