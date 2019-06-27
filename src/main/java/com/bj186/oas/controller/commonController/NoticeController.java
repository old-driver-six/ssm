package com.bj186.oas.controller.commonController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.common.NoticeInsertBean;
import com.bj186.oas.entity.common.SelectAllBean;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.service.common.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Announcements> insert(@RequestBody SelectAllBean selectAllBean){
        System.out.println(666);
        List<Announcements> announcements;
        if (selectAllBean.getValue() == null || selectAllBean.getField().equals("")){
            announcements = noticeService.selectAnnsByKey(selectAllBean.getuId());
        }else {
            announcements = noticeService.selectAnnsByLikeKey(selectAllBean.getuId(),selectAllBean.getField(),selectAllBean.getValue());
        }
        return announcements;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public OAResoult selectAll(@RequestBody NoticeInsertBean noticeInsertBean){
        noticeInsertBean.setAnnouncementsNotifierid(noticeInsertBean.getuId());
        Integer integer = noticeService.insertAnn(noticeInsertBean.getuId(), noticeInsertBean, noticeInsertBean.getDepNames());
        System.out.println(integer);
        OAResoult oaResoult = new OAResoult();
        oaResoult.setCode(integer);
        return oaResoult;
    }
    @RequestMapping("/selectDetails")
    @ResponseBody
    public Announcements selectAnn(@RequestBody Announcements announcements){
        return noticeService.selectAnn(announcements.getAnnouncementsId());
    }
    @RequestMapping("/select")
    @ResponseBody
    public OAResoult select(@RequestParam Integer uId,@RequestParam Integer page,@RequestParam Integer limit,
                            @RequestParam String field,@RequestParam String value){
        OAResoult oaResoult = noticeService.selectAnnsByNotifier(uId, page, limit,field,value);
        return oaResoult;
    }
    @RequestMapping("/update")
    @ResponseBody
    public OAResoult updateAnn(@RequestBody NoticeInsertBean noticeInsertBean){
        OAResoult oaResoult = new OAResoult();
        int i = noticeService.updateByPrimaryKey(noticeInsertBean.getuId(), noticeInsertBean, noticeInsertBean.getDepNames());
        System.out.println(i);
        oaResoult.setCode(i);
        return oaResoult;
    }
}
