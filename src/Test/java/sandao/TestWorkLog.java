package sandao;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.mapper.LeaveAdviceMapper;
import com.bj186.oas.mapper.WorkLogMapper;
import com.bj186.oas.pojo.WorkLog;
import com.bj186.oas.pojo.personalpojo.WorkLogUtil;
import com.bj186.oas.service.personal.WorkLogService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestWorkLog {
    private ApplicationContext ac;
    private WorkLogMapper bean;
    @Before
    public void init(){
        ac=new ClassPathXmlApplicationContext("config/spring.xml");
        bean = ac.getBean(WorkLogMapper.class);
    }

    /**
     * 测试查询日志信息!
     */
    @Test
    public void TestSel(){
        WorkLogUtil util=new WorkLogUtil();
        util.setWorkLogCreatedate1("2019-6-0* %");
        util.setPageSize(1);
        util.setPasgeThis((1-1)*util.getPageSize() );
        List<WorkLog> workLogs = bean.selectWorkBymapper(util);
        System.out.println(workLogs);
    }

    /**
     * 测试添加日志数据
     * @throws NullNameException
     */
    @Test
    public void TestSave() throws NullNameException {
        WorkLogService service = ac.getBean("workLogService", WorkLogService.class);
        OAResoult oaResoult = service.insertWorkLog("测试日志二", 10007, "这是一条测试日志!");
        System.out.println(oaResoult);
    }
    @Test
    public void Testsel2(){
        WorkLogService service = ac.getBean("workLogService", WorkLogService.class);
        OAResoult<List<WorkLog>> resoult = service.selWorkLog(10007);
        System.out.println(resoult);
    }

}
