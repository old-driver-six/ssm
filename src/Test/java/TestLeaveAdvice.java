import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.mapper.LeaveAdviceMapper;
import com.bj186.oas.pojo.LeaveAdvice;
import com.bj186.oas.pojo.personalpojo.LeaveOpinionUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        List<LeaveOpinionUtil> b = bean.selByadvicelid("f2142a2caaae43b18a07ee65f19bf64c");
        System.out.println(b);
    }
}
