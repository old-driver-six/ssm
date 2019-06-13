package com.bj186.crm.test;

import com.bj186.crm.mapper.UserMapper;
import com.bj186.crm.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class UserTest {
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
    public void selectUserByIdTest(){
        User user = sqlSession.selectOne("com.bj186.crm.mapper.UserMapper.selectUserById", 1l);
        System.out.println(user);
    }
    @Test
    public void selectUserByIdTest_2(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(3l);
        System.out.println(user);
    }
    @Test
    public void selectUserByIdTest_3(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById2(6l);
        System.out.println(user);
    }
    @Test
    public void selectAll(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println(users);
    }
    @Test
    public void addUserTest(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("叶来春");
        user.setPassword("ylc123");
        mapper.addUser(user);
        sqlSession.commit();
        System.out.println(user);
    }
    @Test
    public void updateUserTest(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById2(6l);
        System.out.println(user);
        user.setUsername("叶来春");
        user.setPassword("ylc123");
        mapper.updateUser(user);
        sqlSession.commit();
        System.out.println(user);
    }
    @Test
    public void deleteUserTest(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById2(6l);
        System.out.println(user);
        mapper.deleteUser(user);
        sqlSession.commit();
    }
    @After
    public void destroy(){
        sqlSession.close();
    }
}
