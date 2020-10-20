package com.shiro.demo.dao;

import com.shiro.demo.pojo.SysCourseClass;

import java.util.List;

/**
 * @Project demo
 * @Description: SysCourseClassMapper
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 14:40
 */
public interface SysCourseClassMapper {

    List<SysCourseClass> selectCourseClassList(SysCourseClass courseClass);
}
