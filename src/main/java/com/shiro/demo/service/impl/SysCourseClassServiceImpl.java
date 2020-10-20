package com.shiro.demo.service.impl;

import com.shiro.demo.dao.SysCourseClassMapper;
import com.shiro.demo.dao.SysCourseMapper;
import com.shiro.demo.pojo.SysCourseClass;
import com.shiro.demo.service.SysCourseClassService;
import com.shiro.demo.utils.constant.CourseClassConstants;
import com.shiro.demo.utils.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (课程类型) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysCourseClassServiceImpl implements SysCourseClassService {

    @Autowired
    SysCourseClassMapper courseClassMapper;

    @Autowired
    SysCourseMapper courseMapper;


    /**
     * 根据条件分页查询类型列表
     *
     * @return 类型信息集合信息
     */
    @Override
    public List<SysCourseClass> selectCourseClassList(SysCourseClass courseClass) {
        return courseClassMapper.selectCourseClassList(courseClass);
    }

}
