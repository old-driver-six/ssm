package system;

import com.bj186.oas.controller.systemController.DepController;
import com.bj186.oas.entity.system.Dep;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDep {
    private DepController depController;
    private ApplicationContext context;
    @Before
    public void init(){
        context=new ClassPathXmlApplicationContext("config/spring.xml");
        depController = context.getBean(DepController.class);
    }
//    @Test
//    public void selectDep(){
//        List<Dep> depList = depController.selectDep();
//    }
}
