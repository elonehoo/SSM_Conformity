package com.SSM.test;

import com.SSM.beans.Department;
import com.SSM.beans.Employee;
import com.SSM.dao.DepartmentMapper;
import com.SSM.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testInsertDept(){
        /*departmentMapper.insertSelective(new Department(null,"开发部门"));
        departmentMapper.insertSelective(new Department(null,"测试部门"));
        departmentMapper.insertSelective(new Department(null,"运维部门"));
        departmentMapper.insertSelective(new Department(null,"创意部门"));*/
//        employeeMapper.insertSelective(new Employee(null,"张三","M","ZhangSan@163.com",1));
        /*for (){
            employeeMapper.insertSelective(new Employee(null,"张三","M","ZhangSan@163.com",1));
        }*/
        /*System.out.println("开始");
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0 ; i < 1000 ; i++){
            String name = UUID.randomUUID().toString().substring(0, 5);
            mapper.insertSelective(new Employee(null,name,"M",name + "@163.com",1));
        }
        System.out.println("结束");*/

        /*Integer id = 3;
        int i = employeeMapper.deleteByPrimaryKey(id);
        //1===> -2147482646
        //2===> -2147482646
        //3===> -2147482646
        System.out.println(i);*/
        int i = employeeMapper.insertSelective(new Employee(null, "hcy", "M", "hcy163.com", 1));
        System.out.println(i);
    }


    @Test
    public void testSelect(){
        List<Department> list = departmentMapper.selectByExample(null);
        System.out.println(list);
    }
}
