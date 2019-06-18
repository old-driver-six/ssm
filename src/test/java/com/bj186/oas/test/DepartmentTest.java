package com.bj186.oas.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class DepartmentTest {
    Reader resourceAsReader;
    SqlSessionFactory sessionFactory;
    SqlSession sqlSession;
    @Before
    public void init(){
        try {
            resourceAsReader = Resources.getResourceAsReader("config/myBatis/SqlMapConfig.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
            sqlSession = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void selectDepartment(){
        long l1 = System.currentTimeMillis();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = departmentMapper.selectDepartmentById(2);
        System.out.println(department.getEmployees().size());
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
    }
    @Test
    public void selectEmployee(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.selectEmployeeById(10013);
        System.out.println(employee);
        System.out.println(employee.getDepartment());
    }
    @Test
    public void selectBill(){
        BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = billMapper.selectBillById(15573016752669242l);
        System.out.println(bill);
    }
    @Test
    public void selectFood(){
        FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
        Food food = foodMapper.selectFoodById(111l);
        System.out.println(food);
    }
    @After
    public void destroy(){
        sqlSession.close();
    }
}
