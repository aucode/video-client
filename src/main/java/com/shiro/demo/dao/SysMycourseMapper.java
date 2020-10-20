package com.shiro.demo.dao;

import com.shiro.demo.pojo.SysCourse;
import com.shiro.demo.pojo.SysMycourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * (我的课程) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysMycourseMapper {

    int selectMycoursetByUserIdAndCoureId(@Param("courseId") Long courseId,@Param("userId") int userId);

    String selectMycoursetNameByUserIdAndCoureId(@Param("courseId") Long courseId,@Param("userId") int userId);

    List<SysMycourse> selectMycoursetList(@Param("userId") int userId);

    int addMycourseInfo(List<SysCourse> mycourse);


}
