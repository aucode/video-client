package com.shiro.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiro.demo.dao.SysCourseMapper;
import com.shiro.demo.dao.SysMycourseMapper;
import com.shiro.demo.dao.SysShoppingCartMapper;
import com.shiro.demo.pojo.SysCourse;
import com.shiro.demo.pojo.SysMycourse;
import com.shiro.demo.service.SysMycourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * (我的课程) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysMycourseServiceImpl implements SysMycourseService {
    @Autowired
    private SysMycourseMapper mycourseMapper;

    @Autowired
    private SysCourseMapper courseMapper;

    @Autowired
    private SysShoppingCartMapper shoppingCartMapper;

    @Override
    public PageInfo<SysMycourse> selectMycoursetList(int page,int limit,int userId) {
        PageHelper.startPage(page, limit, "mycourse_id DESC");
        List<SysMycourse> sysMycourses = mycourseMapper.selectMycoursetList(userId);
        return new PageInfo<>(sysMycourses);
    }

    @Override
    public int selectMycoursetByUserIdAndCoureId(Long courseId, int userId) {
        return mycourseMapper.selectMycoursetByUserIdAndCoureId(courseId,userId);
    }

    @Override
    public String selectMycoursetNameByUserIdAndCoureId(Long courseId, int userId) {
        return mycourseMapper.selectMycoursetNameByUserIdAndCoureId(courseId,userId);
    }

    @Override
    public int addMycourseInfo(Long[] courseId,Integer uId) {
        //1.查找课程信息
        List<SysCourse> sysCourses = courseMapper.queryCourseInfoByIds(courseId);
        for (int i = 0; i < sysCourses.size(); i++) {
            sysCourses.get(i).setUserId(uId);
        }
        //2.赋值
        //3.删除购物车
        if(shoppingCartMapper.deleteCartInfoByUid(uId) == 0){
            return 0;
        }else {
            return mycourseMapper.addMycourseInfo(sysCourses);
        }
    }
}
