package com.bj186.oas.shiro;

import com.bj186.oas.pojo.Power;
import com.bj186.oas.pojo.Users;
import com.bj186.oas.service.system.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Users user = null;
        // 把AuthenticationToken实质为UsernamePasswordToken，直接转换即可
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        user = userService.selectUsersByKey(usernamePasswordToken.getUsername());          // 通过service查询用户名是否存在
        if (user == null)
            throw new UnknownAccountException("用户不存在！");
        if (user.getUsersState().equals("1"))
            throw new LockedAccountException("用户已被冻结！");
        System.out.println("doGetAuthenticationInfo username=" + user.getUsersPhone());
        System.out.println("doGetAuthenticationInfo password=" + user.getUsersPassword());

        //  spring_database.xml文件中已经对此UserRealm bean对象设置了加密方式和次数，固这里无需重复配置，如果xml文件中没有配置，则需要代码配置
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("MD5");                      // 加密方式，与注册一致
//        hashedCredentialsMatcher.setHashIterations(11);                            // 加密次数，与注册一致
//        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);           // true是默认值，代表16机制值，如果设置false则为base64
//        setCredentialsMatcher(hashedCredentialsMatcher);                           // 保存加密设置
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsersPhone());    // 以用户名为加密盐值
        String realmName = getName();                                              // 当前realm对象的name，调用父类的getName()方法即可

        //认证的核心
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getUsersPassword(), credentialsSalt, realmName);

        // 在没有加盐的情况下，三个参数就可以进行初步的简单认证信息对象的包装
//        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getSimpleName());
        return info;
    }

    @Override
    // 权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Object principal = principalCollection.getPrimaryPrincipal();            //获取登录的用户pojo对象
        Users user = (Users)principal;
        List<Power> powerList = user.getPowerList();
        System.out.println("AuthorizationInfo principal=" + principal);
        for (Power power : powerList) {
            if("公告发布".equals(power.getPowerName())){
                info.addRole("notice");
            }
            if("制度发布".equals(power.getPowerName())){
                info.addRole("inst");
            }
            if("请假审批".equals(power.getPowerName())){
                info.addRole("user");
            }
        }
    /*
       根据不同的权限判断可访问的资源
       info.addRole("1")中的形参值，在spring_database.xml中shiroFilter进行配置
    */
//        if("1".equals(auth)){
//            info.addRole("admin");
//            info.addRole("call");
//        }
//        if("2".equals(auth)){
//            info.addRole("user");
//        }
        info.addRole("all");

        return info;

    }
}
