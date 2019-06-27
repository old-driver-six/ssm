package com.bj186.oas.service.system.systemImpl;

import com.bj186.oas.Util.MD5;
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
     * 根据手机号查询
     * @param phone
     * @return Users对象
     */
    @Override
    public Users selectUsersByKey(String phone) {
        Users users =usersMapper.selectByPrimaryKey(phone);
        return users;

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
        params.put("start",(pageNum-1)*pageSize+1);//sql语句从哪里开始 页码-1 乘以 分页数据数量
        params.put("end", pageSize); //分页数量
        params.put("depName",depName);
        if(!depName.equals("董事局")){
            if(!filed.equals("dep_Name") || filed.equals("dep_Name") && value.equals(depName)){
                staffList = staffMapper.selectByDep(params);
            }else{
                return null;
            }
        }else{
            staffList = staffMapper.selectByDep(params);
        }
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
    public Integer Suspension(Integer staffID) {
        if( usersMapper.Suspension(staffID)==1){
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
    public String insert(User user) {

        Staff staff = new Staff();

        staff.setStaffName("叶123123");
        staff.setStaffPhone("13281989189");
        staff.setStaffAge((byte)21);
        staff.setStaffAdress("成都");
        staff.setStaffBirthday(new Date());
        staff.setStaffEmail("193572912@qq.com");
        staff.setStaffIdntitycardid("511521199712166158");
        staff.setStaffSex("1");
        staff.setStaffWage("15k");

        Department department = new Department();
        department.setDepId(2);
        staff.setDepartment(department);

        Position position = new Position();
        position.setPositionId(1);
        staff.setPosition(position);

        staffMapper.insert(staff);

//        List<Power> powerList = new ArrayList<>();
        String[] strings = new String[]{"制度发布","公告发布"};
        int[] ints = new int[]{1,3};
        for (int i : ints) {
            StaffPower staffPower = new StaffPower();
            staffPower.setSpPowerid(i);
            staffPower.setSpStaffid(staff.getStaffId());
           staffPowerMapper.insert(staffPower);
        }

        Users users = new Users();
        String md5 = MD5.getMd5(staff.getStaffPhone(), staff.getStaffPhone().substring(5));
        users.setUsersPassword(md5);
        users.setUsersPhone(staff.getStaffPhone());
        users.setUsersState("0");

        usersMapper.insert(users);

        return "success";
    }

    /**
     *  修改信息 必须包含所有信息 建议查询信息进行修改
     * @param staff
     * @return success 成功 error 失败
     */
    @Override
    public String update(Staff staff) {
        if( staffMapper.updateByPrimaryKey(staff)==1){
            return "success";
        }
        return "error";
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
