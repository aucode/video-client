package com.shiro.demo.service;

import com.github.pagehelper.PageInfo;
import com.shiro.demo.dao.SysCourseClassMapper;
import com.shiro.demo.pojo.SysCourseClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project demo
 * @Description: SysCourseClassServuce
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 14:39
 */
public interface SysCourseClassServuce {
    PageInfo<SysCourseClass> selectCourseClassList(int page, int limit, SysCourseClass courseClass);
}
