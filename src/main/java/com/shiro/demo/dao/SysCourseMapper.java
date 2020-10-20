package com.shiro.demo.dao;

import com.shiro.demo.pojo.SysCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Project demo
 * @Description: SysCourseMapper
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 15:49
 */
public interface SysCourseMapper {
    List<SysCourse> selectCourseList(SysCourse course);

    List<SysCourse> getFreeCourses();

    List<SysCourse> basicCourse();

    List<SysCourse> seniorCourses();

    List<SysCourse> queryCourseInfoByIds(@Param("companyIds") Long[] courseId);

    SysCourse queryCourseById(Long courseId);
}
