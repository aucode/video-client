package com.shiro.demo.service;


import com.github.pagehelper.PageInfo;
import com.shiro.demo.pojo.SysMycourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * (我的课程) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysMycourseService {

    PageInfo<SysMycourse> selectMycoursetList(int page,int limit,int userId);

    int selectMycoursetByUserIdAndCoureId(Long courseId,int userId);

    String selectMycoursetNameByUserIdAndCoureId(@Param("courseId") Long courseId, @Param("userId") int userId);

    int addMycourseInfo(Long[] courseId,Integer uId);

}
