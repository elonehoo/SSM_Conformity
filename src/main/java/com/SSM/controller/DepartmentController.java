package com.SSM.controller;

import com.SSM.beans.Department;
import com.SSM.beans.Employee;
import com.SSM.beans.Msg;
import com.SSM.dao.DepartmentMapper;
import com.SSM.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DepartmentController {
    @Resource
    DepartmentMapper departmentMapper;

    @RequestMapping(value = "/dept",produces ={"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public String getDept() throws JsonProcessingException {
        List<Department> departments = departmentMapper.selectByExample(null);
        ObjectMapper mapper = new ObjectMapper();
        String mapJakcson = mapper.writeValueAsString(departments);
        System.out.println(mapJakcson);
        return mapJakcson;
    }
}
