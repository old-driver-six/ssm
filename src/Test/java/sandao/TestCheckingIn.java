package sandao;


import com.bj186.oas.pojo.CheckingIn;
import com.bj186.oas.service.personal.CheckingInService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCheckingIn {
    private ApplicationContext context;
    private CheckingInService checkingInService;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("config/spring.xml");
        checkingInService = context.getBean(CheckingInService.class);
    }

    @Test
    public void selectTest() {


    }

    @Test
    public void selectByStaffId() {


    }
}

