package sandao;

import com.bj186.oas.Util.Massgs;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.mapper.LeaveMapper;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.pojo.personalpojo.*;
import com.bj186.oas.service.personal.LeaveService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestLeave {
    private ApplicationContext ac;
    @Before
    public void init(){
            ac=new ClassPathXmlApplicationContext("config/spring.xml");
    }
    @Test
    /**
     * 测试添加请假条
     */
    public void insert(){
        LeaveService bean = ac.getBean(LeaveService.class);
        Leave leave=new Leave();
        leave.setLeaveId(UUIDUtil.getUUID());
        leave.setLeaveStaffId(10007);
        leave.setLeaveProcessing("正常");
        leave.setLeaveTitle("生病了");
        leave.setLeaveType("1");
        leave.setLeaveTime(16);
        leave.setLeaveState("1");
        leave.setLeaveReason("生病了,难受!");
        leave.setLeaveCeatetime(System.currentTimeMillis());
        OAResoult<List<Massgs>> insert = bean.insert(leave);
        System.out.println(insert);

        /**
         * 普通员工发送消息的类容
         * NoteResoult{status=200, msg='添加成功,正在通知领导审批!', date=Massgs{TableKey=c2cc62fcdbb54392baac57136329b5a1, sid='10004', uid='10002', msg='你有一个新的请假审核!'}}
         */

        /**
         * 部门领导添加成功后返回的消息内容
         * NoteResoult{status=200, msg='添加成功,正在通知领导审批!', date=null}
         */

    }
    @Test
    public void Test1(){
        System.out.println("0".equals(null));
    }
    @Test
    public void TestSel(){
        LeaveMapper bean = ac.getBean(LeaveMapper.class);
        List<Leave> leaves = bean.selectByPrimaryKey();
        System.out.println(leaves);
    }

    /**
     * 级联查询
     */
    @Test
    public void TestSe2(){
        LeaveMapper bean = ac.getBean(LeaveMapper.class);
        GetLeaveUtil getLeaveUtil=new GetLeaveUtil();
        /*getLeaveUtil.setSid(10007);
        getLeaveUtil.setSendTime(20);
        getLeaveUtil.setLeaveTime(2);*/
        //getLeaveUtil.setLid("3f4c51d3060049c187fea69a12bb8f58");
        getLeaveUtil.setLivd("8c00498d0965450fa9efcb8ad242dbf8");
        List<Leave> leaves = bean.selLeaveLeftAdvice(getLeaveUtil);
        System.out.println(leaves);
    }

    /**
     * 查询出第一次用户看到的请假的简略信息
     */
    @Test
    public void Test3(){
        LeaveMapper bean = ac.getBean(LeaveMapper.class);
        List<ShowLeave> showLeaves = bean.showLeaves(10007);
        System.out.println(showLeaves.get(0));
    }
    @Test
    public void Test4(){
        LeaveMapper bean = ac.getBean(LeaveMapper.class);
       // Paging<ShowLeave> pagings = bean.showLeaveLimit(10007);
        //System.out.println(pagings);
    }
    @Test
    public void Test5(){
        LeaveMapper bean = ac.getBean(LeaveMapper.class);
        String leaveId="2f9b792ba5a3489eba5f2cd39e8ef6b6";
        Leave leave = bean.selectByPrimaryKey(leaveId);
        System.out.println(leave);
    }
    @Test
    public void Test6() throws ParseException {
        LeaveMapper bean = ac.getBean(LeaveMapper.class);
        Page<GetLeaveUtil> page=new Page<>();
        page.setSid(10007);
        page.setPageSize(1);
        page.setPageThis(0);
        GetLeaveUtil getLeaveUtil=new GetLeaveUtil();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date parse1 = format.parse("2019-06-03");
        Date parse = format.parse("2019-06-06");
        getLeaveUtil.setCreateDate(parse1);
        getLeaveUtil.setSendDate(parse);
        page.setEntity(getLeaveUtil);
        Paging<ShowLeave> paging = bean.showLeaveLimit(page);
    }
    @Test
    public void Test7(){
        LeaveMapper bean = ac.getBean(LeaveMapper.class);
        StaffInfo<Leave> leaveAdive = bean.getLeaveAdive("01e6079e1f6249799b0210fa81473c7e");
        System.out.println(leaveAdive);
    }
}
