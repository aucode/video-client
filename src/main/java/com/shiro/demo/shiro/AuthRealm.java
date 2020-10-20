package com.shiro.demo.shiro;

import com.shiro.demo.pojo.Permission;
import com.shiro.demo.pojo.Role;
import com.shiro.demo.pojo.User;
import com.shiro.demo.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * @CLASSNAME AuthRealm
 * @DESCRIPTION 描述
 * @AUTHOR chen
 * @DATE 2018-11-24 15:43
 **/
public class AuthRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    //授权 这里取消授权了，方便理解登录认证，想要测试授权认证取消注释即可
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //session获取用户信息
        User user = (User) principals.fromRealm( this.getClass().getName() ).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List <String> roleNameList = new ArrayList <>();
        Set<Role> roleSet = user.getRoles();
        if (CollectionUtils.isNotEmpty( roleSet )) {
            for (Role role : roleSet) {
                roleNameList.add( role.getRname() );
                Set <Permission> permissionSet = role.getPermissions();
                if (CollectionUtils.isNotEmpty( permissionSet )) {
                    for (Permission permission : permissionSet) {
                        permissionList.add( permission.getName() );
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions( permissionList );
        info.addRoles(roleNameList );//角色授权
        return info;
    }

    //认证登录md5 加密认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();//
        User user = userService.login( username );
        if (user == null){
            throw new AccountException( "用户不存在" );
        }
        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        return new SimpleAuthenticationInfo( user,user.getPassword(),credentialsSalt,realmName );
    }

/*

    //认证登录不需要md5加密，取消CredentialMatcher这个类的注释
   //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User user = userService.findByName( username );
        return new SimpleAuthenticationInfo( user, user.getPassword(), this.getClass().getName() );
    }
 */

}
