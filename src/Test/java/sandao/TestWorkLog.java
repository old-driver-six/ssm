package sandao;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.mapper.LeaveAdviceMapper;
import com.bj186.oas.mapper.WorkLogMapper;
import com.bj186.oas.pojo.WorkLog;
import com.bj186.oas.pojo.personalpojo.Paging;
import com.bj186.oas.pojo.personalpojo.WorkLogUtil;
import com.bj186.oas.service.personal.CalendarService;
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
        util.setPageThis((1-1)*util.getPageSize() );
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

    /**
     * 测试通过时间区间查询
     */
    @Test
    public void TestSe12(){
        WorkLogService service = ac.getBean("workLogService", WorkLogService.class);
        OAResoult<List<WorkLog>> resoult = service.selWorkLog("2019-6-12", "2019-6-30", 1,10007);
        /**
         * type为二,修改时间区间查询
         * Preparing: select worklog_id, worklog_name, worklog_createdate, worklog_updatetime, worklog_createID , worklog_content from oas_worklog WHERE worklog_updatetime >=? and worklog_updatetime <=?
         */
        System.out.println(resoult);
    }

    /**
     * 测试统计总数方法！
     */
    @Test
    public void TestSeLcount(){
        Integer integer = bean.selCount(null);
        System.out.println(integer);

    }
    @Test
    public void TestSelLimit(){
        WorkLogUtil workLogUtil=new WorkLogUtil();
        workLogUtil.setWorklogCreateid(10007);
        workLogUtil.setPageSize(1);
        workLogUtil.setPageThis(0);
        Paging<WorkLog> workLogPaging = bean.selLimitWork(workLogUtil);
        System.out.println(workLogPaging);
    }
    @Test
    public void TestUpadte() throws NullNameException {
        CalendarService calendarService = ac.getBean("calendarService", CalendarService.class);
        OAResoult resoult = calendarService.updateCalendar(null, null, "周事务", null, null, "31eb2644bdf842719c3f6d76cc9ce04d");
        System.out.println(resoult);
    }
}
