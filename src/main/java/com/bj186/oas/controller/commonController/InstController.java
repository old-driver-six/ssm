package com.bj186.oas.controller.commonController;

import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.entity.common.NoticeInsertBean;
import com.bj186.oas.entity.common.RuleInsertBean;
import com.bj186.oas.entity.common.SelectAllBean;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Rule;
import com.bj186.oas.service.common.InstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rule")
public class InstController {
    @Autowired
    private InstService instService;
    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Rule> insert(@RequestBody SelectAllBean selectAllBean){
        Map<String,String> map = new HashMap<>();
        map.put("field",selectAllBean.getField());
        map.put("value","\'%"+selectAllBean.getValue()+"%\'");
        return instService.selectRuleAll(map);
    }
    @RequestMapping("/select")
    @ResponseBody
    public OAResoult select(@RequestParam Integer uId, @RequestParam Integer page, @RequestParam Integer limit,
                            @RequestParam String field, @RequestParam String value){
        OAResoult oaResoult = instService.selectRuleByCreatorId(uId, page, limit,field,value);
        return oaResoult;
    }
    @RequestMapping("/selectDetails")
    @ResponseBody
    public Rule selectAnn(@RequestBody Rule rule){
        return instService.selectRule(rule.getRuleId());
    }
    @RequestMapping("/update")
    @ResponseBody
    public OAResoult updateAnn(@RequestBody Rule rule){
        OAResoult oaResoult = new OAResoult();
        int i = instService.updateByPrimaryKey(rule);
        oaResoult.setCode(i);
        return oaResoult;
    }
//    @RequestMapping("/insert")
//    @ResponseBody
//    public String selectAll(@RequestBody NoticeInsertBean noticeInsertBean){
//        noticeInsertBean.setAnnouncementsNotifierid(noticeInsertBean.getuId());
//        Integer integer = noticeService.insertAnn(noticeInsertBean.getuId(), noticeInsertBean, noticeInsertBean.getDepNames());
//        System.out.println(integer);
//        if (integer == 0){
//            return "添加失败！";
//        }else if (integer == -1) {
//            return "没有权限！";
//        }
//        return "添加成功";
//    }
//    @RequestMapping("/selectDetails")
//    @ResponseBody
//    public Announcements selectAnn(@RequestBody Announcements announcements){
//        return noticeService.selectAnn(announcements.getAnnouncementsId());
//    }
//    @RequestMapping("/update")
//    @ResponseBody
//    public Integer updateAnn(@RequestBody NoticeInsertBean noticeInsertBean){
//        int i = noticeService.updateByPrimaryKey(noticeInsertBean.getuId(), noticeInsertBean, noticeInsertBean.getDepNames());
//        return i;
//    }
}
