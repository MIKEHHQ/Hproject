package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.annotation.NeedNoToken;
import cn.edu.sdu.ise.labs.dto.BillDTO;
import cn.edu.sdu.ise.labs.dto.query.BillQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.service.BillService;
import cn.edu.sdu.ise.labs.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HHQ
 */
@RestController
@RequestMapping("bill")
public class BillController {

    @Autowired
    private BillService billService;

    @NeedNoToken
    @PostMapping("add")
    public Integer add(@RequestBody BillDTO billDTO) {
        return billService.addBill(billDTO);
    }

    @NeedNoToken
    @PostMapping("update")
    public Integer update(@RequestBody BillDTO billDTO) {
        return billService.updateBill(billDTO);
    }

    @NeedNoToken
    @PostMapping("list")
    public Page<BillVO> list(@RequestBody BillQueryDTO queryDTO) {
        return billService.listByPage(queryDTO);
    }

    @NeedNoToken
    @PostMapping("delete")
    public boolean delete(@RequestBody List<Integer> ids) {
        billService.deleteByCodes(ids);
        return true;
    }
}

