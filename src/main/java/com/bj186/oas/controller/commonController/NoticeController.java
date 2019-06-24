package com.bj186.oas.controller.commonController;

import com.bj186.oas.entity.common.NoticeInsertBean;
import com.bj186.oas.entity.common.NoticeSelectAllBean;
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
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Announcements> insert(@RequestBody NoticeSelectAllBean selectAllBean){
        System.out.println(666);
        List<Announcements> announcements;
        if (selectAllBean.getValue() == null){
            announcements = noticeService.selectAnnsByKey(selectAllBean.getuId());
        }else {
            announcements = noticeService.selectAnnsByLikeKey(selectAllBean.getuId(),selectAllBean.getField(),selectAllBean.getValue());
        }
        return announcements;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public String selectAll(@RequestBody Announcements announcements){
        announcements.setAnnouncementsNotifierid(announcements.getuId());
        Integer integer = noticeService.insertAnn(announcements.getuId(), announcements, announcements.getDepartments());
        System.out.println(integer);
        if (integer == 0){
            return "添加失败！";
        }else if (integer == -1) {
            return "没有权限！";
        }
        return "添加成功";
    }
}
