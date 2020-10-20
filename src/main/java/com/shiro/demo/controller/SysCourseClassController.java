package com.shiro.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shiro.demo.pojo.SysCourseClass;
import com.shiro.demo.service.SysCourseClassServuce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Project demo
 * @Description: SysCourseClassController
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 14:37
 */
@Controller
public class SysCourseClassController {
    @Autowired
    private SysCourseClassServuce courseClassServuce;

    @RequestMapping("course/class/list")
    @ResponseBody
    public PageInfo<SysCourseClass> courseClassList(@RequestParam("page") int page,@RequestParam("limit") int limit, SysCourseClass courseClass){
        return courseClassServuce.selectCourseClassList(page,limit,courseClass);
    }
}
