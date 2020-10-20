package com.shiro.demo.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @CLASSNAME Role
 * @DESCRIPTION 描述
 * @AUTHOR chen
 * @DATE 2018-11-24 15:05
 **/
@Getter
@Setter
public class Role {

    private Integer rid;

    private String rname;

    private Set <Permission> permissions = new HashSet <>();

    private Set <User> users = new HashSet <>();
}
