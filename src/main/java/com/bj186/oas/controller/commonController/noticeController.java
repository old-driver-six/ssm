package com.bj186.oas.controller.commonController;

import com.bj186.oas.bean.SelectAllBean;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.service.common.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class noticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Announcements> selectAll(@RequestBody SelectAllBean selectAllBean){
        System.out.println(666);
        List<Announcements> announcements;
        if (selectAllBean.getValue() == null){
            announcements = noticeService.selectAnnsByKey(selectAllBean.getuId());
        }else {
            announcements = noticeService.selectAnnsByLikeKey(selectAllBean.getuId(),selectAllBean.getField(),selectAllBean.getValue());
        }
        return announcements;
    }
}
