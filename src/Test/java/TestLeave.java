import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.service.personal.LeaveService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLeave {
    private ApplicationContext ac;
    @Before
    public void init(){
            ac=new ClassPathXmlApplicationContext("config/spring.xml");
    }
    @Test
    public void insert(){
        LeaveService bean = ac.getBean(LeaveService.class);
        Leave leave=new Leave();
        leave.setLeaveId(UUIDUtil.getUUID());
        leave.setLeaveStaffId(10001);
        leave.setLeaveProcessing("正常");
        leave.setLeaveTitle("生病了");
        leave.setLeaveType("1");
        leave.setLeaveTime(1);
        leave.setLeaveState("1");
        leave.setLeaveReason("生病了,难受!");
        leave.setLeaveCeatetime(System.currentTimeMillis());
        Boolean insert = bean.insert(leave);
        System.out.println(insert);
    }

}
