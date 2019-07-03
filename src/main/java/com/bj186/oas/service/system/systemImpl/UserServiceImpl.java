package com.bj186.oas.service.system.systemImpl;

import com.bj186.oas.Util.MD5;
import com.bj186.oas.entity.UpdatePwd;
import com.bj186.oas.entity.system.User;
import com.bj186.oas.mapper.*;
import com.bj186.oas.pojo.*;
import com.bj186.oas.service.system.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private StaffMapper staffMapper;
    @Resource
    private Mapper mapper;
    @Resource
    private UsersMapper usersMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private StaffPowerMapper staffPowerMapper;
    @Resource
    private PowerMapper powerMapper;

    /**
     * 根据ID查询
     * @param staffID
     * @return staff对象
     */
    @Override
    public Staff selectByPrimaryKey(Integer staffID) {
        Staff staff = staffMapper.selectByPrimaryKey(staffID);
        return staff;

    }
    /**
     * 根据姓名查询
     * @param staffName
     * @return staff对象
     */
    @Override
    public  Staff selectByName(String staffName){
        Staff staff = staffMapper.selectByName(staffName);
        return staff;

    }

    /**
     * 根据手机号查询
     * @param phone
     * @return Users对象
     */
    @Override
    public Users selectUsersByKey(String phone) {
        Users users =usersMapper.selectByPrimaryKey(phone);
        return users;

    }

    @Override
    public Integer updatePwd(UpdatePwd updatePwd) {
        Staff staff = staffMapper.selectByPrimaryKey(updatePwd.getuId());
        Users user = usersMapper.select(staff.getStaffId());
        String md5 = MD5.getMd5(staff.getStaffPhone(), updatePwd.getPassword());
        if(!md5.equals(user.getUsersPassword()))
            return -1;
        user.setUsersPassword(MD5.getMd5(staff.getStaffPhone(), updatePwd.getNewPassword()));
        usersMapper.updateByStaffId(user);
        return 0;
    }


    /**
     *
     * @param filed 字段
     * @param value 值
     * @param pageSize 分页数据数量
     * @param pageNum 分页页码
     * @return
     */
    @Override
    public List<Staff> select(String filed, String value, Integer pageSize, Integer pageNum) {
        Map<String,Object> params = new LinkedHashMap<String,Object>();
        //当sql的条件有模糊匹配时，参数需前后带上%
        params.put("filed",filed);//字段
        params.put("value", "\'%"+value+"%\'");//模糊查询
        params.put("start",(pageNum-1)*pageSize);//sql语句从哪里开始 页码-1 乘以 分页数据数量
        params.put("end", pageSize); //分页数量
        List<Staff> staffList = staffMapper.select(params);
        System.out.println("查询成功");
        return staffList;
    }

    /**
     *
     * @param filed 字段
     * @param value 值
     * @param pageSize 分页数据数量
     * @param pageNum 分页页码
     * @return
     */
    @Override
    public List<Staff> selectByDep(String depName,String filed, String value,Integer pageSize, Integer pageNum) {
        Map<String,Object> params = new LinkedHashMap<String,Object>();
        List<Staff> staffList = new ArrayList<>();
        params.put("filed",filed);//字段
        params.put("value", "\'%"+value+"%\'");//模糊查询
        params.put("start",(pageNum-1)*pageSize);//sql语句从哪里开始 页码-1 乘以 分页数据数量
        params.put("end", pageSize); //分页数量
        params.put("depName",depName);

        staffList = staffMapper.selectLimit(params);

        return staffList;
    }

    /**
     * 查询所有信息
     * @return 员工列表
     */
    @Override
    public List<Staff> selectAll() {
        List<Staff> staffList = staffMapper.selectAll();
        return staffList;
    }

    /**
     * 查询表数据总数
     * @return count 总数
     */
    @Override
    public Integer selectCount(String tableName) {
        Map<String,Object> map = new HashMap<>();
        map.put("tableName",tableName);
        Integer count = mapper.selectCount(map);
        System.out.println(count);
        return count;
    }

    /**
     * 停职方法
     * @param staffID 被停职人
     * @return
     */
    @Override
    public Integer suspension(Integer staffID) {
        if( usersMapper.suspension(staffID)==1){
            return 200;
        }
        return -1;
    }
    /**
     * 复职方法
     * @param staffID 被复职人
     * @return
     */
    @Override
    public Integer office(Integer staffID) {
        if( usersMapper.office(staffID)==1){
            return 200;
        }
        return -1;
    }

    /**
     * 离职方法
     * @param staffID 被离职人
     * @return
     */
    @Override
    public Integer lizhi(Integer staffID) {
        if( usersMapper.lizhi(staffID)==1){
            return 200;
        }
        return -1;
    }

    @Override
    public Integer Departure(Integer staffID) {
        if( usersMapper.Departure(staffID)==1){
            Department department = staffMapper.selectByPrimaryKey(staffID).getDepartment();
            department.setDepNumber(department.getDepNumber()-1);
            departmentMapper.updateByPrimaryKeySelective(department);
            return 200;
        }
        return -1;
    }

    @Override
    public Integer Reinstatement(Integer staffID) {
        if( usersMapper.Reinstatement(staffID)==1){
            return 200;
        }
        return -1;
    }

    /**
     *  插入员工方法
     * @param user
     * @return success 成功 error 失败
     */
    @Override
    public Integer insert(Staff user,List<Integer> powerIdList) {

        System.out.println(222);
        if(staffMapper.insert(user)==0){
            return -1;
        }
        for (int i : powerIdList) {
            StaffPower staffPower = new StaffPower();
            staffPower.setSpPowerid(i);
            staffPower.setSpStaffid(user.getStaffId());
            if(staffPowerMapper.insert(staffPower)==0)
                return -1;
        }
        System.out.println(888);
        Users users = new Users();
        users.setStaffId(user.getStaffId());
        users.setUsersState("0");
        users.setUsersPassword(MD5.getMd5(user.getStaffPhone(), user.getStaffPhone().substring(5)));
        System.out.println(999);
        if(usersMapper.insert(users) == 0){
            return -1;
        }

            Department department = staffMapper.selectByPrimaryKey(user.getStaffId()).getDepartment();
            department.setDepNumber(department.getDepNumber()+1);
           if(departmentMapper.updateByPrimaryKeySelective(department)==0){
               return -1;
           }
            return 200;

    }

    /**
     *  重置密码
     * @param users
     * @return success 成功 error 失败
     */
    @Override
    public Integer updateRes(Users users) {
        System.out.println(users.getStaffId());
        Users select = usersMapper.select(users.getStaffId());
        String md5 = MD5.getMd5(select.getUsersPhone(), select.getUsersPhone().substring(5));
        users.setUsersPassword(md5);
      if(usersMapper.updateByStaffId(users)==1)
          return 200;
      else
          return -1;
    }

    /**
     *  修改信息 必须包含所有信息 建议查询信息进行修改
     * @param user
     * @return success 成功 error 失败
     */
    @Override
    public Integer update(User user) {

        Staff staff = new Staff();
        staff.setStaffId(user.getStaffId());
        staff.setStaffName(user.getStaffName());
        staff.setStaffPhone(user.getStaffPhone());
        staff.setStaffAge(user.getStaffAge());
        staff.setStaffAdress(user.getStaffAdress());
        staff.setStaffBirthday(user.getStaffBirthday());
        staff.setStaffEmail(user.getStaffEmail());
        staff.setStaffIdntitycardid(user.getStaffIdntitycardid());
        staff.setStaffSex(user.getStaffSex());
        staff.setStaffWage(user.getStaffWage());

        if(user.getDepId()==3&&user.getPositionId()!=1 || user.getPositionId()==1&&user.getDepId()!=3){
           return -1;
        }

        Position position = new Position();

        position.setPositionId(user.getPositionId());
        staff.setPosition(position);

        Department department = departmentMapper.selectById(user.getDepId());
        if(user.getPositionId()==2){
            Integer depManagerid = department.getDepManagerid();
            Staff staff1 = staffMapper.selectByPrimaryKey(depManagerid);
            position.setPositionId(4);
            staff1.setPosition(position);
            staffMapper.updateByPrimaryKeySelective(staff1);

            department.setDepManagerid(staff.getStaffId());
            departmentMapper.updateByPrimaryKeySelective(department);
        }



        staff.setDepartment(department);



        if(staffMapper.updateByPrimaryKeySelective(staff) ==0)
            return -1;


        staffPowerMapper.delete(user.getStaffId());

        for (int i : user.getPowerIdList()) {
            StaffPower staffPower = new StaffPower();
            staffPower.setSpPowerid(i);
            staffPower.setSpStaffid(staff.getStaffId());
            if(staffPowerMapper.insert(staffPower)==0)
                return -1;
        }

        Users users = new Users();
        users.setUsersState("0");

        if(usersMapper.updateByStaffId(users)==0)
            return -1;

        return 200;
    }

    /**
     *  删除信息 根据ID
     * @param staffID
     * @return success 成功 error 失败
     */
    @Override
    public String delete(Integer staffID) {
        if( staffMapper.deleteByPrimaryKey(staffID)==1){
            return "success";
        }
        return "error";
    }

    /**
     *  修改信息 有哪些就修改那些 动态SQL
     * @param staff
     * @return success 成功 error 失败
     */
    @Override
    public String updateByPrimaryKeySelective(Staff staff) {
        if( staffMapper.updateByPrimaryKeySelective(staff)==1){
            return "success";
        }
        return "error";
    }
}
