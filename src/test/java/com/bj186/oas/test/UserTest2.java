package com.bj186.oas.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:config/spring/spring_tx.xml")
public class UserTest2 {
    ClassPathXmlApplicationContext context;
    UserService userService;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("config/spring/spring_tx.xml");
        userService = context.getBean("userService", UserService.class);
    }
    @Test
    public void selectBillTest(){
        User user = new User();
        user.setUsername("熊大");
        user.setPassword("xd123");
        userService.addUser(user);
        System.out.println(user);
    }
}
