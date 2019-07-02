package com.bj186.oas.service.personal.Impl;

import com.bj186.oas.Util.Massgs;
import com.bj186.oas.Util.OAResoult;
import com.bj186.oas.Util.UUIDUtil;
import com.bj186.oas.exception.NullNameException;
import com.bj186.oas.mapper.LeaveAdviceMapper;
import com.bj186.oas.mapper.LeaveMapper;
import com.bj186.oas.mapper.StaffMapper;
import com.bj186.oas.pojo.Leave;
import com.bj186.oas.pojo.LeaveAdvice;
import com.bj186.oas.pojo.personalpojo.GetLeaveUtil;
import com.bj186.oas.pojo.personalpojo.LeaveOpinionUtil;
import com.bj186.oas.service.personal.LeaveService;
import com.bj186.oas.service.personal.LeaveUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper mapper;     //请假表映射关系
    @Autowired
    private StaffMapper staffMapper;  //用户表映射关系
    @Autowired
    private LeaveAdviceMapper leaveAdviceMapper;        //请假意见表的id
    @Autowired
    private LeaveUtil leaveUtil;
    /**
     * 添加请假条成功后需要给领导发消息,经理级别的请假直接给总裁审批
     * @param leave
     * @return
     */
    @Override
    public OAResoult<List<Massgs>> insert(Leave leave) {
        OAResoult<List<Massgs>> oaResoult=new OAResoult<>();
        oaResoult.setCode(-1);
        oaResoult.setMsg("服务器繁忙,请稍后再试!");
        leave.setLeaveId(UUIDUtil.getUUID());                   //后端赋值
        leave.setLeaveCeatetime(System.currentTimeMillis());    //后端赋值
        //leave.setLeaveState("1");                               //默认未审核成功!
        int insert = mapper.insert(leave);
        if(insert>0){
            oaResoult.setCode(200);
            oaResoult.setMsg("添加成功,正在通知领导审批!");
            List<Massgs> messages = createMessages(leave.getLeaveStaffId(), leave.getLeaveId());
            System.out.println(messages);
            oaResoult.setData(messages);     //调用产生消息类,产生一个新的消息
        }
        return oaResoult;
    }

    /**
     * 目前请假不允许修改,这里是新建请假条意见
     * @param opinion   请假意见
     * @param state     请假状态值0为同意,1为不同意
     * @param lid       请假表的id
     * @param sid       操作人id
     * @return
     */
    @Override
    public OAResoult<List<Massgs<String>>> updateLeave(String opinion, String state, String lid, Integer leaveTime, Integer sid, Integer uid)throws Exception{
        OAResoult<List<Massgs<String>>> resoult=new OAResoult<>();
        //判断当前请假表是是否已经请假完成了
        List<LeaveOpinionUtil> leaveOpinionUtils = leaveAdviceMapper.selByadvicelid(lid);
        System.out.println("数据库中是否存在:"+leaveOpinionUtils);
        if(leaveOpinionUtils==null||leaveOpinionUtils.isEmpty()){    //如果请假条件没有完成了说明请假已经完成
            //情况1,第一次创建
            List<Massgs<String>> massgs = new ArrayList<>();
            if(leaveTime<=3){       //判断请假时间是否小于三天
                Massgs<String> masg = returnGroupMasg(lid, opinion, state, uid, sid);
                masg.setMsg("审批失败!");
                /**
                 * 不管多少层级第一次都会走这个方法,第一层级走到这个方法的时候
                 * 可以修改请假表的状态!
                 */
                masg=SelupdateLeave(state,lid,masg);
                massgs.add(masg);
                if(massgs!=null||massgs.isEmpty()){     //如果返回的消息不为空,则可以继续操作
                    resoult.setCode(200);
                    resoult.setData(massgs);
                    return resoult;
                }
            }
            if(leaveTime>3){
                List<Massgs<String>> masg = returnTowMasg(lid, opinion, state, sid, uid,null);
                if(massgs!=null&&!massgs.isEmpty()){     //如果返回的消息不为空,则可以继续操作
                    masg.get(0).setMsg("组长审批通过!");
                    resoult.setCode(200);
                    resoult.setData(masg);
                    return resoult;
                }
            }
            resoult.setCode(-1);
            resoult.setMsg("系统故障!请稍后重试");
            return resoult;
        }else if(!"0".equals(leaveOpinionUtils.get(0).getLeaveState())){  //判断请假是否审核通过了
            //情况二已经审核一次但是没有通过
            List<Massgs<String>> massgs = returnUpdateMasg(leaveTime, lid, opinion, state, uid, sid,leaveOpinionUtils.get(0).getLeaveadviceId());
            System.out.println("请假意见返回值"+massgs);
            if(massgs!=null){
                resoult.setCode(200);
                resoult.setData(massgs);
                return resoult;
            }
            resoult.setCode(-1);
            resoult.setMsg("系统故障!请稍后重试");
            return resoult;
        }
        resoult.setCode(200);
        resoult.setMsg("请假已被其他领导审批通过!");
        return resoult;
    }

    @Override
    public OAResoult<Leave> getLeave(String lid) {
        OAResoult<Leave> resoult=new OAResoult<>();
        resoult.setData(mapper.selectByPrimaryKey(lid));
        resoult.setCode(200);
        return resoult;
    }

    @Override
    public OAResoult<List<Leave>> getLeave() {
        OAResoult<List<Leave>> resoult=new OAResoult<>();
        resoult.setData(mapper.selectByPrimaryKey());
        resoult.setCode(200);
        return resoult;
    }

    @Override
    public OAResoult CkeckLeaveProcess(String lid,Integer sid) {
        OAResoult resoult=new OAResoult();
        GetLeaveUtil getLeaveUtil=new GetLeaveUtil();
        getLeaveUtil.setSid(sid);
        getLeaveUtil.setLid(lid);
        List<Leave> leaves = mapper.selLeaveLeftAdvice(getLeaveUtil);
        Integer leaveTime = leaves.get(0).getLeaveTime();
        if(leaveTime<=3){
            LeaveAdvice advice = leaves.get(0).getLeaveAdvices().get(0);
            if("".equals(advice.getAdvicegroupstate())){
                resoult.setCode(200);
                resoult.setMsg("组长审核中!");
            }
        }
        return null;
    }

    @Override
    public OAResoult update(Leave leave) throws NullNameException {
        OAResoult resoult=new OAResoult();
        if(leave==null){
            resoult.setCode(-1);
            resoult.setMsg("系统故障请稍后重试!");
            return resoult;
        }
        int update = mapper.updateByPrimaryKeySelective(leave);
        if(update==0){
           throw  new NullNameException("修改失败!请稍后重试!");
        }
        resoult.setCode(0);
        resoult.setMsg("修改成功!");
        return resoult;
    }

    /**
     * 创建消息
     * @param sid    当前操作对象的工号
     * @return 如果查询出来的id不为本人且不为空,则返回一条完整的消息,否则为空
     *
     */
    private List<Massgs> createMessages(Integer sid,String TableK){

        //判断当前员工的职务 员工 组长 部门经理 人事部门经理
        List<Integer> list = returnLer(sid);
        List<Massgs> mas=new ArrayList<>();
        for (Integer integer : list) {
            if(integer!=null&& !integer.equals(sid)){       //当查询出来的用户id不为空且不等于自己的时候,则说明有审核人
                Massgs<String> massgs=new Massgs();
                massgs.setUid(integer.toString());      //消息目标对象的id
                massgs.setMsg("你有一个新的请假审核!");   //消息内容
                massgs.setTableKey(TableK);             //请假表的主键
                massgs.setSid(sid.toString());          //发送这个消息的人
                mas.add(massgs);
            }
        }
        return mas;
    }

    /**
     * 通过员工id返回直属领导的id
     * @param sid
     * @return
     */
    public List<Integer> returnLer(Integer sid){
        String s = staffMapper.SelPsot(sid);
        List<Integer> lerid =null;
        Map<String,Object> map=new Hashtable<>();

        map.put("sid",sid);
        switch (s){
            case "员工":
                map.put("groupLer","主管");
                lerid=staffMapper.SelGouop(map);
                break;
            case "主管":
                map.put("groupLer","经理");
                lerid=staffMapper.SelGouop(map);
                break;
            case "经理":
                map.clear();   //清空map信息
                map.put("groupLer","员工");
                map.put("depname","人事部");
                lerid=staffMapper.SelGouop(map);
                break;
        }
        return lerid;
    }


    /**
     * 创建修改的返回信息
     * @param time  请假时间
     * @param lid   请假条id
     * @param opinion   意见
     * @param state     状态
     * @return          通知消息
     */
    private List<Massgs<String>> returnUpdateMasg(Integer time,String lid,String opinion, String state,Integer uid,Integer sid,String lidvid)throws Exception{
        List<Massgs<String>> resout=new ArrayList<>();
        if(time<=3){     //小于三天
           resout.add(returnGroupMasg(lid,opinion,state,uid,sid));
          return resout;
       }
       if(3<time&&time<15){     //大于三天小于十五天,需要组长和部门经理审核
           List<Massgs<String>> massgs = returnTowMasg(lid, opinion, state, sid, uid,lidvid);
           return massgs;
       }
       if(time>15){             //请假第三级,大于十五天,由人事审核
          return returnThreeMsg(lid,opinion,state,sid,uid,lidvid);
       }
        return null;
    }


    /***
     * 请假第一级,第一审批,小于三天的情况,只需要小组长审核
     * @param lid 请假条id
     * @param opinion  意见
     * @param state     意见状态
     * @param uid       收件人id
     * @param sid       发件人id
     * @return          消息集合
     */
    private Massgs<String> returnGroupMasg(String lid,String opinion, String state,Integer uid,Integer sid) throws Exception{
        //查询请假表
        LeaveAdvice leaveAdvice=new LeaveAdvice();
        leaveAdvice.setLeaveadviceId(UUIDUtil.getUUID());
        leaveAdvice.setAdvicelid(lid);
        leaveAdvice.setAdvicegroup(opinion);
        leaveAdvice.setAdvicegroupstate(state);
        int insert = leaveAdviceMapper.insert(leaveAdvice);
        if(insert==0){
            throw new  NullPointerException("系统故障请稍后重试!");
        }
        Massgs<String> msg = createOPinionMsg(sid, uid, leaveAdvice.getLeaveadviceId());
        return msg;
    }

    /**
     * 第二次请假
     * @param lid       请假条id
     * @param opinion   意见状态
     * @param state     意见状态
      *@param  uid      收件人id
     * @param sid       发件人id
     * @param lidvid    请假意见表的id
     * @return
     */
    private List<Massgs<String>>  returnTowMasg(String lid,String opinion, String state,Integer sid,Integer uid,String lidvid)throws Exception{
        String psot = staffMapper.SelPsot(sid);
        List<Massgs<String>> resout=new ArrayList<>();
        if("主管".equals(psot)){
            List<Integer> integers = returnLer(sid);        //只有一个经理,所以直接给经理广播消息就好了
            /**
             * 判断组长审核是否通过,如果没有通过则直接返回给提交请假申请的用户
             */
            if("0".equals(state)){
                Massgs<String> massgs = returnGroupMasg(lid, opinion, state, integers.get(0), sid);
                resout.add(massgs);
                return resout;
            }
            Massgs<String> massgs = returnGroupMasg(lid, opinion, state,uid, sid);
            massgs.setMsg("主管审核不通过!");
            resout.add(massgs);
            return resout;
        }
        if ("经理".equals(psot)){
            LeaveAdvice leaveAdvice=new LeaveAdvice();
            leaveAdvice.setLeaveadviceId(lidvid);
            leaveAdvice.setAdvicepart(opinion);
            leaveAdvice.setAdvicepartstate(state);
            int i=-1;
            if("".equals(lidvid)||null==lidvid){       //如果id为空的话,就执行增加方法
                leaveAdvice.setLeaveadviceId(UUIDUtil.getUUID());
                leaveAdvice.setAdvicelid(lid);
                i=leaveAdviceMapper.insert(leaveAdvice);
            }else{              //如果不为空的话,就执行修改方法
                i = leaveAdviceMapper.updateByPrimaryKeySelective(leaveAdvice);
            }
            if(i==0){
                leaveAdvice.setLeaveadviceId(UUIDUtil.getUUID());
                throw new Exception();
            }
            //将消息返回给请假人和组长
            Leave leave = mapper.selectByPrimaryKey(lid);
            resout.add(createOPinionMsg(sid, uid, leaveAdvice.getLeaveadviceId()));      //给组长发消息
            resout.add(createOPinionMsg(sid, leave.getLeaveStaffId(), leaveAdvice.getLeaveadviceId()));     //给请假人发消息
            SelupdateLeave(state,lid);          //如果为0修改请假表状态
            return resout;
        }
        return resout;
    }

    /**
     * 请假第三级,到了人事之后的操作
     * @param lid
     * @param opinion
     * @param state
     * @param sid
     * @param uid
     * @param lidvid
     * @return
     * @throws Exception
     */
    private List<Massgs<String>> returnThreeMsg(String lid,String opinion, String state,Integer sid,Integer uid,String lidvid) throws Exception{
        String psot = staffMapper.SelPsot(sid);
        //System.out.println("当前员工职位:"+psot);
        List<Massgs<String>> resout=new ArrayList<>();
        lidvid = leaveUtil.insertAdvice(lid, opinion, state, psot, lidvid);
        //System.out.println("返回的表主键:"+lidvid);
        if(!"".equals(lidvid)||null!=lidvid){     //判断是添加成功
            if("主管".equals(psot)){      //如果职位是组长
                if(!"0".equals(state)){     //如果组长审核没通过,直接返回给操作用户!
                    resout.add(createOPinionMsg(sid, uid, lidvid));
                    return resout;
                }
                List<Integer> integers = returnLer(sid);
                resout.add(createOPinionMsg(sid,integers.get(0),lidvid));
                System.out.println(createOPinionMsg(sid,integers.get(0),lidvid));
                return resout;
            }
            if("经理".equals(psot)){
                if(!"0".equals(state)){     //如果经理没有同意
                    Leave leave = mapper.selectByPrimaryKey(lid);
                    resout.add(createOPinionMsg(sid,uid,lidvid));       //将信息返回给组长
                    resout.add(createOPinionMsg(sid,leave.getLeaveStaffId(),lidvid));       //将信息返回给用户
                    return resout;
                }
                uid=returnLer(sid).get(0);
                resout.add(createOPinionMsg(sid,uid,lidvid));
                return resout;
            }
            if("员工".equals(psot)){
                SelupdateLeave(state,lid);       //修改请假表状态
                resout.add(createOPinionMsg(sid,uid,lidvid));       //给部门经理发送请假结果

                Leave leave = mapper.selectByPrimaryKey(lid);
                resout.add(createOPinionMsg(sid,leave.getLeaveStaffId(),lidvid));       //给操作员工发送请假结果
                List<Integer> list = returnLer(leave.getLeaveStaffId());
                for (Integer integer : list) {
                   resout.add(createOPinionMsg(sid,integer,lidvid));                    //给组长们发消息
                }
                return resout;
            }
        }
        return null;
    }

    /**
     * 创建请假审批意见
     * @param sid   发件人id
     * @param uid   收件人id
     * @param TableKey  意见表主键
     *      审核意见状态,这个如果填0了就会修改请假表,二层以上,第一不写这个
     *        最终审核通过时才填写这个字段
     * @return
     */
    private Massgs<String> createOPinionMsg(Integer sid,Integer uid,String TableKey)throws Exception{
        Massgs<String> massgs=new Massgs<>();
        massgs.setSid(sid.toString());       //发件人id
        massgs.setUid(uid.toString());       //收件人id
        massgs.setTableKey(TableKey);      //请假意见表主键
        return massgs;
    }

    /**
     * 如果请假通过了就执行该方法修改请假表的状态,修改消息实体类
     * @param state 请假意见
     * @param lid   请假条id
     * @param massgs    消息实体类
     * @return
     */
    private Massgs<String> SelupdateLeave(String state,String lid,Massgs massgs){
        if("0".equals(state)){       //如果状态为0说明小组长同意了这个请求
            Leave leave=new Leave();
            leave.setLeaveState("0");
            leave.setLeaveId(lid);
            int i = mapper.updateByPrimaryKeySelective(leave);
            if(i==0){        //如果返回值小于零,抛异常让事物回滚!
                throw new  NullPointerException("系统故障请稍后重试!");
            }
            massgs.setMsg("审批成功!");
        }
        return massgs;
    }

    /**
     * 请假审核通过修改请假表
     * @param state
     * @param lid
     */
    private void SelupdateLeave(String state,String lid){
        if("0".equals(state)){       //如果状态为0说明小组长同意了这个请求
            Leave leave=new Leave();
            leave.setLeaveState("0");
            leave.setLeaveId(lid);
            int i = mapper.updateByPrimaryKeySelective(leave);
            if(i==0){        //如果返回值小于零,抛异常让事物回滚!
                throw new  NullPointerException("系统故障请稍后重试!");
            }
        }
    }
}
