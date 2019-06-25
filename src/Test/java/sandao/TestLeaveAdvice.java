package sandao;

import com.bj186.oas.Util.Massgs;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.mapper.LeaveAdviceMapper;
import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.LeaveAdvice;
import com.bj186.oas.pojo.personalpojo.LeaveOpinionUtil;
import com.bj186.oas.service.personal.LeaveService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * 测试请假意见表
 */
public class TestLeaveAdvice {
    private ApplicationContext ac;
    private LeaveAdviceMapper bean;
    @Before
    public void init(){
        ac=new ClassPathXmlApplicationContext("config/spring.xml");
        bean = ac.getBean(LeaveAdviceMapper.class);
    }

    /**
     * 添加情假意见表
     */
    @Test
    public void insert(){
        LeaveAdvice advice=new LeaveAdvice();
        advice.setLeaveadviceId(UUIDUtil.getUUID());
        advice.setAdvicegroup("这段时间太忙,请假一天太久了,请改为半天时间!");
        advice.setAdvicegroupstate("1");
        advice.setAdvicelid("f2142a2caaae43b18a07ee65f19bf64c");
        int insert = bean.insert(advice);
        System.out.println(insert);
    }

    /**
     * 通过请假条id查询这条意见是否存在,如果不存在,说明是第一次上报
     * 返回值直接去请假表的状态,如果请假表状态为未通过,则说明请假还没有通过,
     * 则可能是前面的请假条件没有通过.这次是有提交过来需要领导继续审核的
     */
    @Test
    public void Test(){
        LeaveAdviceMapper bean = ac.getBean(LeaveAdviceMapper.class);
        List<LeaveOpinionUtil> b = bean.selByadvicelid("3f4c51d3060049c187fea69a12bb8f58");
        System.out.println(b);
    }

    /**
     * 测试根据当前员工的信息查询出直属领导的id,方便通知他审核DAO1
     */
    @Test
    public void TestSelLeader(){
        StaffMapper bean = ac.getBean(StaffMapper.class);
        System.out.println(bean.SelLeader(10001));
    }

    /**
     * 通过员工id查询出他当前的直属领导经理
     */
    @Test
    public void TestSelGouop(){
        StaffMapper bean = ac.getBean(StaffMapper.class);
        Map<String,Object> map=new Hashtable<>();
        map.put("groupLer","经理");
       /* map.put("sid",10007);*/
        map.put("depname","人事部");
        List<Integer> integers = bean.SelGouop(map);
        System.out.println(integers);
    }

    /**
     * 通过员工id查询他的职务
     */
    @Test
    public void TestSelPsot(){
        StaffMapper bean = ac.getBean(StaffMapper.class);
        String s = bean.SelPsot(10007);
        System.out.println(s);
    }

    //智能通过员工id查询出他当前的直属领导DAO
    @Test
    public void TestreturnLer(){
       /* LeaveService bean = ac.getBean("leaveService", LeaveService.class);
        List<Integer> integers = bean.returnLer(10001);
        System.out.println(integers);*/

        /**
         * 测试用例一:普通员工id 10007
         * 返回:
         * Parameters: 组长(String), 10007(Integer)
         * <==    Columns: Staff_id
         * <==        Row: 10006
         * <==      Total: 1
         */

        /**
         * 测试用例二:组长:10006
         * 返回:
         * Parameters: 经理(String), 10006(Integer)
         * <==    Columns: Staff_id
         * <==        Row: 10001
         * <==      Total: 1
         * [10001]
         */

        /**
         * 测试用例三: 经理 10002
         * 返回:
         *  ==> Parameters: 经理(String), 人事部(String)
         * <==    Columns: Staff_id
         * <==        Row: 10001
         * <==      Total: 1
         * Closing non transactional SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@28c0b664]
         * [10001]      返回人事经理的id
         */
    }

    /**
     * 测试请假第一种情况,三天以下
     */
    @Test
    public void TestupdateLeave() throws Exception {
        LeaveService bean = ac.getBean("leaveService", LeaveService.class);
        /*OAResoult<List<Massgs<String>>> resoult = bean.updateLeave("测试失败!","1","3f4c51d3060049c187fea69a12bb8f58",1,10006,10007);
        System.out.println(resoult);*/

        /**
         * 第一次提交请假申请,失败情况
         * 参数:"测试失败!","1","3f4c51d3060049c187fea69a12bb8f58",1,10006,10007
         * 返回值:NoteResoult{status=200, msg='null', date=[Massgs{TableKey=f33bf537c7b24402bd43b28d3a3b0ada, sid='10006', uid='10007', msg='审批失败!'}]}
         */
        OAResoult<List<Massgs<String>>> resoult = bean.updateLeave("测试成功!","0","3f4c51d3060049c187fea69a12bb8f58",1,10006,10007);
        System.out.println(resoult);
        /**
         * 成功情况:
         * 参数:"测试成功!","0","3f4c51d3060049c187fea69a12bb8f58",1,10006,10007
         * 返回值:NoteResoult{status=200, msg='null', date=[Massgs{TableKey=2e7a2a47d49d430ab5146eb553cf109b, sid='10006', uid='10007', msg='审批成功!'}]}
         *
         */
    }
    /**
     * 测试第二种情况,三天以上
     */
    @Test
    public void TestupdateLeave1() throws Exception{
        LeaveService bean = ac.getBean("leaveService", LeaveService.class);
        OAResoult<List<Massgs<String>>> resoult = bean.updateLeave("测试成功!","1","ad0ef725d9ee42118fea73a97bc00a70",4,10001,10006);
       // OAResoult<List<Massgs<String>>> resoult = bean.updateLeave("测试成功!","0","ad0ef725d9ee42118fea73a97bc00a70",4,10006,10007);
        System.out.println(resoult);
        /**
         * 返回值:
         *  NoteResoult{status=200, msg='null', date=[Massgs{TableKey=15e5ecd1556f40b2b275f26bf72452f6, sid='10001', uid='10006', msg='null'},
         *  Massgs{TableKey=15e5ecd1556f40b2b275f26bf72452f6, sid='10001', uid='10006', msg='null'}]}
         */
    }

    /**
     * 测试请假十五天以上
     * @throws Exception
     */
    @Test
    public void TestupdateLeave2() throws Exception {
        LeaveService bean = ac.getBean("leaveService", LeaveService.class);
        OAResoult<List<Massgs<String>>> resoult = bean.updateLeave("测试成功!","1","cfcb010f57944a47ac5b7d4b46c1d824",16,10006,10007);
        System.out.println(resoult);
    }
    @Test
    public void TestupdateLeave3() throws Exception {
        LeaveService bean = ac.getBean("leaveService", LeaveService.class);
        OAResoult<List<Massgs<String>>> resoult = bean.updateLeave("测试成功!","0","c0df5fcf9ef7406da759683d164c81e0",16,10013,10001);
        System.out.println(resoult);
    }
}
