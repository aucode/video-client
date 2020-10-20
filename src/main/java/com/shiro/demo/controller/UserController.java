package com.shiro.demo.controller;

import com.shiro.demo.pojo.User;
import com.shiro.demo.service.SysCourseClassServuce;
import com.shiro.demo.service.SysCourseService;
import com.shiro.demo.service.SysRotationChartService;
import com.shiro.demo.service.UserService;
import com.shiro.demo.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * @CLASSNAME UserController
 * @DESCRIPTION
 * @AUTHOR
 * @DATE
 **/
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private SysCourseService courseService;

    @Autowired
    private SysCourseClassServuce courseClassServuce;

    @Autowired
    private SysRotationChartService sysRotationChartService;

    @RequestMapping("login")
    public String login1() {
        return "page/login";
    }

    @RequestMapping("unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping("/")
    public String initIndex(ModelMap modelMap) {
        modelMap.put("courseclass",courseClassServuce.selectCourseClassList(1,15,null));
        modelMap.put("courselist",courseService.selectCourseList(1,8,null));
        modelMap.put("coursefreelist",courseService.getFreeCourses());
        modelMap.put("coursebasiclist",courseService.basicCourse());
        modelMap.put("courseseniorlist",courseService.seniorCourses());
        modelMap.put("imglist",sysRotationChartService.selectRotationChartList());
        return "page/index";
    }

    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        modelMap.put("courseclass",courseClassServuce.selectCourseClassList(1,15,null));
        modelMap.put("courselist",courseService.selectCourseList(1,8,null));
        modelMap.put("coursefreelist",courseService.getFreeCourses());
        modelMap.put("coursebasiclist",courseService.basicCourse());
        modelMap.put("courseseniorlist",courseService.seniorCourses());
        modelMap.put("imglist",sysRotationChartService.selectRotationChartList());
        return "page/index";
    }

    @RequestMapping("admin")
    @ResponseBody
    public String admin() {
        return "admin ok";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String edit() {
        return "edit ok";
    }

    @RequestMapping("add")
    @ResponseBody
    public String add() {
        return "add ok";
    }

    @ResponseBody
    @RequestMapping("delete")
    public String delete() {
        return "delete ok";
    }

    @RequestMapping("loginUser")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            HttpSession session, ModelMap modelMap) {
        UsernamePasswordToken token = new UsernamePasswordToken( username, password );
        Subject subject = SecurityUtils.getSubject();
        //认证逻辑
        try {
            subject.login( token );
            User user = (User) subject.getPrincipal();
            session.setAttribute( "user", user );
            modelMap.put("userinfo",user);
            modelMap.put("courseclass",courseClassServuce.selectCourseClassList(1,15,null));
            modelMap.put("courselist",courseService.selectCourseList(1,8,null));
            modelMap.put("coursefreelist",courseService.getFreeCourses());
            modelMap.put("coursebasiclist",courseService.basicCourse());
            modelMap.put("courseseniorlist",courseService.seniorCourses());
            modelMap.put("imglist",sysRotationChartService.selectRotationChartList());
            return "page/index";
        } catch (Exception e) {
            modelMap.put("error","用户名或密码错误。");
            return "page/login";
        }
    }

    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "page/login";
    }

    @ResponseBody
    @RequestMapping("insert")
    public void insert(User user) {
        userService.insert( user );
    }

    @RequestMapping("toRegister")
    public String regUI() {
        return "page/register";
    }

    @RequestMapping("register")
    public String register(User user,ModelMap modelMap){
        ModelAndView mv = new ModelAndView(  );
        User byName = userService.login(user.getUsername());
        if(byName == null ||byName.getUsername().equals("")){
            userService.insert( user );
            return "page/login";
        }
        modelMap.put("error", "用户已存在！" );
        return "page/register";
    }

    @RequestMapping("userChange")
    public String userChange(ModelMap modelMap,User user){
        User user1 = (User) SecurityUtils.getSubject().getPrincipal();
        user.setUid(user1.getUid());
        user.setUsername(user1.getUsername());
        userService.update(user);
        modelMap.put("user",user);
        modelMap.put("error",false);
        return "shopping/profile";

    }

}
