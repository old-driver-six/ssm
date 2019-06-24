package common;

import com.bj186.oas.mapper.AnnouncementsMapper;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.service.common.NoticeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class NoticeTest {
    private ApplicationContext context;
    private NoticeService noticeService;
    @Before
    public void init(){
        context=new ClassPathXmlApplicationContext("config/spring.xml");
        noticeService = context.getBean(NoticeService.class);
    }
    @Test
    public void insertAnn(){
        Announcements announcements = new Announcements();
        announcements.setAnnouncementsContent("测试数据2，测试数据2");
        List<String> depNames = new ArrayList<>();
        depNames.add("人事部");
        depNames.add("行政部");
        Integer integer = noticeService.insertAnn(10001, announcements, depNames);
        System.out.println(integer);
    }
    @Test
    public void selectAnnsByKey(){
        List<Announcements> announcements = noticeService.selectAnnsByKey(10001);
        System.out.println(announcements);
    }
    @Test
    public void selectAnnsByNotifier(){
        List<Announcements> announcements = noticeService.selectAnnsByNotifier(10001);
        System.out.println(announcements);
    }
    @Test
    public void updateByPrimaryKey(){
        AnnouncementsMapper annMapper = context.getBean(AnnouncementsMapper.class);
        Announcements announcements = annMapper.selectByPrimaryKey(10001);
        List<String> depNames = new ArrayList<>();

        depNames.add("人事部");
        depNames.add("行政部");
        int i = noticeService.updateByPrimaryKey(10004, announcements, depNames);
        System.out.println(i);
    }
}
