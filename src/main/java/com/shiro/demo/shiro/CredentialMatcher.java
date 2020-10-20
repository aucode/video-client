//package com.shiro.demo.shiro;
//
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
//
///**
// * @CLASSNAME CredentialMatcher
// * @DESCRIPTION 不需要加密处理
// * @AUTHOR chen
// * @DATE 2018-11-24 16:03
// **/
//public class CredentialMatcher extends SimpleCredentialsMatcher {
//
//    @Override
//    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
//        String password = new String( usernamePasswordToken.getPassword() );//取出token里面的值
//        String dbPwd = (String) info.getCredentials();//取出数据库里面的密码
//
//        //自定义规则
//
////        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
////        matcher.setHashAlgorithmName( "md5" );
////        matcher.setHashIterations( 1 );
//
//        return this.equals( password, dbPwd );
//    }
//}
