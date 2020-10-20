package com.shiro.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiro.demo.dao.SysCourseClassMapper;
import com.shiro.demo.pojo.SysCourseClass;
import com.shiro.demo.service.SysCourseClassServuce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project demo
 * @Description: SysCourseClassImpl
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 14:39
 */
@Service
public class SysCourseClassImpl implements SysCourseClassServuce {

    @Autowired
    private SysCourseClassMapper courseClassMapper;

    @Override
    public PageInfo<SysCourseClass> selectCourseClassList(int page, int limit, SysCourseClass courseClass) {

        //第一个参数为页数，第二个为条数。对这个方法后的第一个sql生效，
        PageHelper.startPage(page, limit, "class_id DESC");

        List<SysCourseClass> sysCourseClasses = courseClassMapper.selectCourseClassList(courseClass);
        //获取分页数据
        return new PageInfo<>(sysCourseClasses);
    }
}
