package com.bj186.oas.service.personal;

import com.bj186.oas.pojo.CheckingIn;

import java.util.List;

public interface CheckingInService {

 List<CheckingIn> selectCheckingInByRequirement(Integer uId, Integer staffId,String startTime,String endTime,String pageNow, String pageLimit);

 

}
