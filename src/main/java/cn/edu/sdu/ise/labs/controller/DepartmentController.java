package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.annotation.NeedNoToken;
import cn.edu.sdu.ise.labs.dto.DepartmentDTO;
import cn.edu.sdu.ise.labs.dto.query.DepartmentQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.service.DepartmentService;
import cn.edu.sdu.ise.labs.vo.DepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门管理后端服务模块
 *
 * @author 李洪文
 * @description
 * @date 2019/12/3 11:07
 */

@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @NeedNoToken
    @PostMapping("add")
    public Integer add(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.addDepartment(departmentDTO);
    }

    @NeedNoToken
    @PostMapping("update")
    public Integer update(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.updateDepartment(departmentDTO);
    }

    @NeedNoToken
    @PostMapping("list")
    public Page<DepartmentVO> list(@RequestBody DepartmentQueryDTO queryDTO) {
        return departmentService.listByPage(queryDTO);
    }

    @NeedNoToken
    @PostMapping("delete")
    public void delete(@RequestBody List<Integer> ids) {
        departmentService.deleteByCodes(ids);
    }
}

