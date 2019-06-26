package system;

import com.bj186.oas.controller.systemController.UserController;
import com.bj186.oas.entity.system.Like;
import com.bj186.oas.service.common.NoticeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    private UserController userController;
    private ApplicationContext context;
    @Before
    public void init(){
        context=new ClassPathXmlApplicationContext("config/spring.xml");
        userController = context.getBean(UserController.class);
    }
    @Test
    public void select(){
        Like like = new Like();
        like.setuId(10004);
        like.setFiled("dep_name");
        like.setValue("行政部");
        like.setPageSize(10);
        like.setPageNum(1);
//        userController.select(like);
    }
    @Test
    public void insert(){
        userController.insert();
    }


}
