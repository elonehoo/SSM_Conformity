package com.SSM.service;

import com.SSM.beans.Employee;
import com.SSM.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有的员工
     * @return
     */
    public List<Employee> getAll() {
        List<Employee> employeeList = employeeMapper.selectByExampleWithDept(null);
        return employeeList;
    }

    public String getDeleteById(Integer id) {
        System.out.println("EmployeeService" + id);
        int i = employeeMapper.deleteByPrimaryKey(id);
        System.out.println("EmployeeService" + i);
        if (i == -2147482646){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    public String getInserEmps(Employee employee) {
        int i = employeeMapper.insertSelective(employee);
        if (i == -2147482646){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
}
