package com.kuang.config;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的UserRealm extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了==》授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //授权请求访问 授权用户root下的kkk允许访问文件
        //info.addStringPermission("root:kkk");
        //从数据库中拿到权限
        //拿到用户的信息
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();//拿到user对象
        info.addStringPermission(currentUser.getPerms());//往里面添加授权信息
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了==》认证");
        //用户密码从数据库中读取
        //下面为了演示方便自定义了账号密码
/*        String name = "root";
        String password = "123456";*/

        //从真实的额数据库中读取用户名和密码

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user = userMapper.queryUser(userToken.getUsername());

        if (user == null){
            return null;//抛出异常 UnknownAccountException
        }

        //下面是密码认证 shiro做
        //第一个参数传的是一个用户 第二个参数传的是密码 做认证

        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
