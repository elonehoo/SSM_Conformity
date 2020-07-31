package com.SSM.controller;

import com.SSM.beans.Employee;
import com.SSM.beans.Msg;
import com.SSM.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理员工增删改查的请求
 */
@Controller
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @RequestMapping(value = "/emps",produces ={"application/json;charset=UTF-8"},method = RequestMethod.GET)
    @ResponseBody
    public String getEmpsWithJSON(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model) throws JsonProcessingException {
        //展示查询的页数，和每一页的个数
        PageHelper.startPage(pn,5);
        //查询全部
        List<Employee> emps = employeeService.getAll();
        //使用PageInfo包装分页之后的结果
        PageInfo pageInfo = new PageInfo(emps,5);
        ObjectMapper mapper = new ObjectMapper();
        Msg msg = Msg.success().add("pageInfo", pageInfo);
        String mapJakcson = mapper.writeValueAsString(msg);
        System.out.println(mapJakcson);
        return mapJakcson;
    }


    @RequestMapping(value = "/emps",produces ={"application/json;charset=UTF-8"},method = RequestMethod.DELETE)
    @ResponseBody
    public String getDeleteById(@RequestParam(value = "id")Integer id){
        System.out.println("EmployeeController" + id);
        //调用Service
        String hint = employeeService.getDeleteById(id);
        System.out.println("EmployeeController" + hint);
        return hint;
    }

    @RequestMapping(value = "/emps",produces ={"application/json;charset=UTF-8"},method = RequestMethod.POST)
    @ResponseBody
    public String postEmps( @RequestBody HashMap<String,Object> map) throws Exception{
        String empName = map.get("empName").toString();
        String email = map.get("email").toString();
        String gender = map.get("gender").toString();
        Employee employee = new Employee(null,empName,gender,email,1);
        String hint = employeeService.getInserEmps(employee);
        return hint;
    }

}
