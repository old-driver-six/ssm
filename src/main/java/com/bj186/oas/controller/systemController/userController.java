package com.bj186.oas.controller.systemController;

import com.bj186.oas.mapper.AnnouncementsMapper;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.AnnouncementsExtent;
import com.bj186.oas.pojo.Department;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.common.NoticeService;
import com.bj186.oas.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private AnnouncementsMapper mapper;
    @RequestMapping("/select")
    @ResponseBody
    public List<Announcements> selectStaffAll() {
        Staff staff = userService.selectByPrimaryKey(10001);
        Map<String, Serializable> map = new HashMap<>();
        map.put("uID",10001);
        map.put("field","announcements_content");
        map.put("content","\'%6%\'");
        return mapper.selectByVague(map);
    }

}
