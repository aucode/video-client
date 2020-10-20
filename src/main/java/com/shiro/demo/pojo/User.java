package com.shiro.demo.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @CLASSNAME User
 * @DESCRIPTION 描述
 * @AUTHOR chen
 * @DATE 2018-11-24 15:05
 **/
@Getter
@Setter
public class User {

    private Integer uid;

    private String username;

    private String loginname;

    private String password;

    private String phonenumber;

    private Set <Role> roles = new HashSet <>();
}
