package com.bj186.oas.service.personal;

import com.bj186.oas.pojo.CheckingIn;

import java.util.List;

public interface CheckingInService {

 List<CheckingIn> selectCheckingInByRequirement(Integer uId, Integer staffId,String startTime,String endTime,String pageNow, String pageLimit);

 Integer updateChecking(Integer uId,CheckingIn checkingIn);

 Integer insertChecking(Integer uId,CheckingIn checkingIn);

 Integer countAllCheckingIns();

 Integer countCheckingIn(Integer uId,Integer staffId,String startTime, String endTime);

 CheckingIn selectByPrimaryKey(Integer uId,String checkinginId);
}
