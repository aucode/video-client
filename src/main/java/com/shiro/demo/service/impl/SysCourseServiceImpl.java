package com.shiro.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiro.demo.dao.SysCourseClassMapper;
import com.shiro.demo.dao.SysCourseMapper;
import com.shiro.demo.pojo.SysCourse;
import com.shiro.demo.service.SysCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project demo
 * @Description: SysCourseServiceImpl
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 15:49
 */
@Service
public class SysCourseServiceImpl implements SysCourseService {
    @Autowired
    private SysCourseMapper courseMapper;

    @Override
    public PageInfo<SysCourse> selectCourseList(int page, int limit, SysCourse course) {
        PageHelper.startPage(page, limit, "course_id DESC");
        List<SysCourse> sysCourses = courseMapper.selectCourseList(course);
        return new PageInfo<>(sysCourses);
    }

    @Override
    public List<SysCourse> getFreeCourses() {
        return courseMapper.getFreeCourses();
    }

    @Override
    public List<SysCourse> basicCourse() {
        return courseMapper.basicCourse();
    }

    @Override
    public List<SysCourse> seniorCourses() {
        return courseMapper.seniorCourses();
    }

    @Override
    public SysCourse queryCourseById(Long courseId) {
        return courseMapper.queryCourseById(courseId);
    }
}
