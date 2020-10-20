package com.shiro.demo.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @CLASSNAME ShiroConfig
 * @DESCRIPTION 描述
 * @AUTHOR chen
 * @DATE 2018-11-24 16:07
 **/
@Configuration
public class ShiroConfig {

    //@Qualifier 上下文的注解

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager( securityManager );

        bean.setLoginUrl( "/login" );
        bean.setSuccessUrl( "/index" );
//        bean.setUnauthorizedUrl( "/unauthorized" );//认证未通过访问路径
        //配置请求拦截
        LinkedHashMap <String, String> filterChainDefinitionMap = new LinkedHashMap <>();
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");//img
        filterChainDefinitionMap.put("/css/**", "anon");//css
        filterChainDefinitionMap.put("/js/**", "anon");//js
        filterChainDefinitionMap.put("/libraries/**", "anon");//js
        filterChainDefinitionMap.put("/revolution/**", "anon");//js
        filterChainDefinitionMap.put("/page/**", "anon");//js
//        filterChainDefinitionMap.put( "/shopping", "authc" );//需要认证
        filterChainDefinitionMap.put( "/pay", "anon" );//不需要认证
//        filterChainDefinitionMap.put( "/loginUser", "anon" );//不需要认证
//        filterChainDefinitionMap.put( "/insert", "anon" );//不需要认证
//        filterChainDefinitionMap.put( "/regUI", "anon" );//不需要认证
//        filterChainDefinitionMap.put( "/register", "anon" );//不需要认证
//        filterChainDefinitionMap.put( "/admin", "roles[admin]" );//只有admin角色才能访问
//        filterChainDefinitionMap.put( "/druid/**", "anon" );//放过所有druid 请求
//        filterChainDefinitionMap.put( "/edit", "perms[edit]" );//只有edit权限才能访问
//        filterChainDefinitionMap.put( "/delete", "perms[delete]" );//只有edit权限才能访问
        filterChainDefinitionMap.put( "/shopping/**", "authc" );//登陆后才能访问
        filterChainDefinitionMap.put( "/mycourse/**", "authc" );//登陆后才能访问

        //...拦截url

        bean.setFilterChainDefinitionMap( filterChainDefinitionMap );
        return bean;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm( authRealm );
        return manager;
    }

    //密码md5 加密处理则注释下面的 1,2并注释CredentialMatcher类，若不使用加密处理则注释3,4并取消CredentialMatcher的注释

    //1
//    @Bean("authRealm")
//    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher) {
//        AuthRealm authRealm = new AuthRealm();
//        //认证存到缓存
////        authRealm.setCacheManager( new MemoryConstrainedCacheManager() );
//        authRealm.setCredentialsMatcher( matcher );
//        return authRealm;
//    }

    //2
//    @Bean("credentialMatcher")
//    public CredentialMatcher credentialMatcher() {
//        return new CredentialMatcher();
//    }

    //3 md5加密
    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setAuthorizationCachingEnabled(false);
        authRealm.setCredentialsMatcher( matcher );
        return authRealm;
    }
    //4 md5 密码加密认证
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(  );
        //指定 加密方式
        matcher.setHashAlgorithmName( "md5" );
        //加密次数
        matcher.setHashIterations( 1 );
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    //spring 的规则
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager( securityManager );
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass( true );
        return creator;
    }

//    public static void main(String[] args) {
//        String hashAlgorithName = "md5";//指定加密方式md5
//        String password = "001";//密码
//        int hashIterations = 1;//加密次数
//        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
//        String obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations).toString();
//        System.out.println(obj);
//
//    }
}
