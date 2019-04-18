package com.shiro;

import com.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lasia on 2019/4/11.
 */
public class ShiroRealm extends AuthenticatingRealm {

    private static Map<String,User> userMap = new HashMap<String,User>();
    static{
        //使用Map模拟数据库获取User表信息
        userMap.put("jack", new User("jack","aaa123",false));
        userMap.put("tom", new User("tom","bbb321",false));
        userMap.put("jean", new User("jean","ccc213",true));
    }


    @Override
    protected SimpleAuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) {
        //1.把AuthenticationToken转换为UsernamePasswordToken
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //2.从UsernamePasswordToken中获取username
        String username = userToken.getUsername();

        //3.调用数据库的方法，从数据库中查询Username对应的用户记录
        System.out.println("从数据看中获取UserName为"+username+"所对应的信息。");
        //Map模拟数据库取数据
        User u = userMap.get(username);

        //4.若用户不行存在，可以抛出UnknownAccountException
        if(u==null){
            throw new UnknownAccountException("用户不存在");
        }

        //5.若用户被锁定，可以抛出LockedAccountException
        if(u.isLocked()){
            throw new LockedAccountException("用户被锁定");
        }

        //7.根据用户的情况，来构建AuthenticationInfo对象,通常使用的实现类为SimpleAuthenticationInfo
        //以下信息是从数据库中获取的
        //1)principal：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
        Object principal = u.getUsername();
        //2)credentials：密码
        Object credentials = u.getPassword();
        //3)realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName = getName();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,realmName);

        return info;
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = "123456";//密码原值
        Object salt = null;//盐值
        int hashIterations = 1024;//加密1024次
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        System.out.println(result);
    }
}
