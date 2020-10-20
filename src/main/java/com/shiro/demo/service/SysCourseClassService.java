package com.shiro.demo.service;



import com.shiro.demo.pojo.SysCourseClass;

import java.util.List;


/**
 * <p>
 * (课程类型) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysCourseClassService {


    /**
     * 根据条件分页查询类型列表
     *
     * @return 类型信息集合信息
     */
    public List<SysCourseClass> selectCourseClassList(SysCourseClass courseClass);


}
