package com.bj186.oas.controller.commonController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.common.MeetingInsertBean;
import com.bj186.oas.entity.common.NoticeInsertBean;
import com.bj186.oas.entity.common.SelectAllBean;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Meeting;
import com.bj186.oas.service.common.MeetingService;
import com.bj186.oas.service.common.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Meeting> selectAll(@RequestBody SelectAllBean selectAllBean){
        List<Meeting> meetings = meetingService.selectMeetByKey(selectAllBean);
        return meetings;
    }
    @RequestMapping("/selectMyAll")
    @ResponseBody
    public OAResoult selectMyAll(@RequestParam Integer uId,@RequestParam Integer page,@RequestParam Integer limit,
                                     @RequestParam String field,@RequestParam String value){
        OAResoult oaResoult = meetingService.selectMyAll(uId, page, limit, field, value);
        return oaResoult;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public OAResoult selectMyAll(@RequestBody Meeting meeting){
        OAResoult oaResoult = meetingService.update(meeting);
        return oaResoult;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public OAResoult selectAll(@RequestBody MeetingInsertBean meetingInsertBean){
        Integer integer = meetingService.insert(meetingInsertBean,meetingInsertBean.getDepNames());
        System.out.println(integer);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(integer);
        return oaResoult;
    }
}
