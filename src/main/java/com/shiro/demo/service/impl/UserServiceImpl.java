package com.shiro.demo.service.impl;

import com.shiro.demo.dao.UserMapper;
import com.shiro.demo.pojo.User;
import com.shiro.demo.service.UserService;
import com.shiro.demo.utils.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @CLASSNAME UserServiceImpl
 * @DESCRIPTION 描述
 * @AUTHOR chen
 * @DATE 2018-11-24 15:11
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByName(String username) {
        return userMapper.findByUserName( username );
    }

    @Override
    public User login(String username) {
        return userMapper.findByName( username );
    }
    @Override
    public User VerifyUserName(String username) {
        return userMapper.findByName( username );
    }

    @Override
    public void insert(User user) {
        User u = new User();
        u.setUsername( user.getUsername() );
        String hashAlgorithName = "md5";
        String password = user.getPassword();
        int hashIterations = 1;
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
        String md5 = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations).toString();
        u.setPassword( md5 );
        userMapper.insert( u );
    }

    @Override
    public void update(User user) {
        User u = new User();
        u.setUsername(user.getUsername());
        u.setLoginname(user.getLoginname());
        u.setUid(user.getUid());
        u.setPhonenumber(null);
        String hashAlgorithName = "md5";
        String password = user.getPassword();
        if(!"".equals(password)){
            int hashIterations = 1;
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
            String md5 = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations).toString();
            u.setPassword( md5 );
            userMapper.update(u);
        }else {
            u.setPassword(null);
            userMapper.update( u );
        }
    }
}
