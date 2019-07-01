package sandao;

import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.mapper.CalendarMapper;
import com.bj186.oas.pojo.Calendar;
import com.bj186.oas.pojo.personalpojo.StaffInfo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestCalendar {
    private CalendarMapper bean=null;
    private ApplicationContext ac;
    @Before
    public void init(){
        ac=new ClassPathXmlApplicationContext("config/spring.xml");
        bean = ac.getBean(CalendarMapper.class);
    }
    @Test
    public void TestSave() throws ParseException {
        Calendar calendar=new Calendar();
        calendar.setCalendarId(UUIDUtil.getUUID());
        calendar.setCalendarStffId(10007);
        calendar.setCalendarType("月事务");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-hh");
        Date parse1 = sdf.parse("2019-6-1");
        Date parse2 = sdf.parse("2019-6-25");
        calendar.setCalendarStarttime(parse1);
        calendar.setCalendarSendtime(parse2);
        calendar.setCalerdarCreatetime(new Date());
        calendar.setCalendarContent("这是一个测试行程内容");
        bean.insert(calendar);
    }
    @Test
    public void TestSelStaff(){
        //Map staffInfo = bean.getStaffInfo(10007);
       /* Set set = staffInfo.keySet();
        for (Object o : set) {
            Object o1 = staffInfo.get(o);
            System.out.println(o1);
        }*/
       StaffInfo<Calendar> staffInfo = bean.getStaffInfo(10007);
        System.out.println(staffInfo.getDataInfo());
    }
}
