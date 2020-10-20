package com.shiro.demo.controller;


import com.shiro.demo.pojo.SysApplicationQuestions;
import com.shiro.demo.pojo.SysQuestionLibrary;
import com.shiro.demo.service.SysCourseClassService;
import com.shiro.demo.service.SysQuestionLibraryService;
import com.shiro.demo.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * (题库表) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("/shopping")
public class SysQuestionLibraryController extends BaseController {
    private String prefix = "shopping";

    @Autowired
    private SysQuestionLibraryService questionLibraryService;


    @Autowired
    private SysCourseClassService sysCourseClassService;

    /**
     * 查看全部题库
     * @param modelMap
     * @return
     */

    @GetMapping("/library")
    public String queryAllQuestionLibrary(ModelMap modelMap)
    {
        modelMap.put("librarys",questionLibraryService.queryAllQuestionLibrary());
        return prefix + "/questionbank";
    }

    /**
     * 题库信息
     * @param libraryId
     * @param questionLibrary
     * @return
     */
    @GetMapping("/7770301CC5E3C4EBEC17DC1C0A53CA06/{id}")
    public String libraryInfo(@PathVariable("id") Long libraryId, SysQuestionLibrary questionLibrary,ModelMap modelMap){
        questionLibrary.setLibraryId(libraryId);
        modelMap.put("questionLibrary",questionLibraryService.getLibraryLists(questionLibrary));
        modelMap.put("applicationQuestions",questionLibraryService.getLibraryapplicationLists(questionLibrary));
        return prefix + "/librarys";
    }

}

