package com.shiro.demo.controller;

import com.github.pagehelper.PageInfo;
import com.shiro.demo.pojo.SysCourse;
import com.shiro.demo.service.SysCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Project demo
 * @Description: SysCourseController
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-12 15:48
 */
@Controller
public class SysCourseController {

    private String prefix = "page";

    @Autowired
    private SysCourseService courseService;


    @RequestMapping("courses/more")
    public String moreCourses(@RequestParam("title") String title, ModelMap modelMap){
        SysCourse course = new SysCourse();
        modelMap.put("title",title);
        modelMap.put("more",courseService.selectCourseList(1,8,course));
        return prefix + "/more";
    }
    @RequestMapping("courses/more/list")
    public String morePageCourses(@RequestParam("title") String title,@RequestParam("page") int page,
                                  ModelMap modelMap){
        SysCourse course = new SysCourse();
        modelMap.put("title",title);
        modelMap.put("more",courseService.selectCourseList(page,8,course));
        return prefix + "/more";
    }

    @RequestMapping("courses/search")
    public String searchCourses(@RequestParam("courseName") String courseName, Integer page,ModelMap modelMap){
        modelMap.put("title",courseName);
        SysCourse course = new SysCourse();
        course.setCourseName(courseName);
        if(null == page){
            modelMap.put("search",courseService.selectCourseList(1,12,course));
        }else {
            modelMap.put("search",courseService.selectCourseList(page,12,course));
        }
        return prefix + "/search";
    }

    @RequestMapping("course/list")
    @ResponseBody
    public PageInfo<SysCourse> courseClassList(@RequestParam("page") int page, @RequestParam("limit") int limit,
                                               SysCourse course){
        return courseService.selectCourseList(page,limit,course);
    }

    @RequestMapping("courses/free/list")
    @ResponseBody
    public List<SysCourse> getFreeCourses(){
        return courseService.getFreeCourses();
    }


    @RequestMapping("courses/basic/list")
    @ResponseBody
    public List<SysCourse> basicCourse(){
        return courseService.basicCourse();
    }

    @RequestMapping("courses/senior/list")
    @ResponseBody
    public List<SysCourse> seniorCourses(){
        return courseService.seniorCourses();
    }

}
