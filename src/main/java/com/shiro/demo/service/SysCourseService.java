package com.shiro.demo.service;

import com.github.pagehelper.PageInfo;
import com.shiro.demo.pojo.SysCourse;

import java.util.List;

/**
 * @Project demo
 * @Description: SysCourseService
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 15:49
 */
public interface SysCourseService {

    PageInfo<SysCourse> selectCourseList(int page, int limit, SysCourse course);

    List<SysCourse> getFreeCourses();


    List<SysCourse> basicCourse();

    List<SysCourse> seniorCourses();

    SysCourse queryCourseById(Long courseId);
}
