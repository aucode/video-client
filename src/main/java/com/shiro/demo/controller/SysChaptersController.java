package com.shiro.demo.controller;



import com.shiro.demo.pojo.SysChapters;
import com.shiro.demo.pojo.User;
import com.shiro.demo.service.SysChaptersService;
import com.shiro.demo.service.SysMycourseService;
import com.shiro.demo.utils.AjaxResult;
import com.shiro.demo.utils.StringUtils;
import com.shiro.demo.utils.page.TableDataInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * (章节表) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
public class SysChaptersController extends BaseController {
    private String prefix = "page/playvideo";

    @Autowired
    private SysChaptersService chaptersService;

    @Autowired
    private SysMycourseService mycourseService;

    /**
     * 课程章节信息
     * @param courseId 课程编号
     * @param mmap
     * @return
     */
    @GetMapping("/play/1249297909e20e53885d26c910575f53/{id}")
    public String coursesChapters(@PathVariable("id") Long courseId, ModelMap mmap){
        SysChapters chapters = new SysChapters();
        chapters.setCourseId(courseId);
        mmap.put("courseId", courseId);
        mmap.put("chaptersId", chapters.getChaptersId());
        mmap.put("videore",null);
        mmap.put("hidden",false);
        mmap.put("chapters",chaptersService.queryChaptersByCourseId(chapters));
        return prefix;
    }
    /**
     * 视频播放
     * @return
     */
    @GetMapping("/video/959d00bfe7a36ff38fae994f43ecf5b3")
    public String courseclass(Long courseId,Long chaptersId, ModelMap mmap){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SysChapters chapters = new SysChapters();
        chapters.setChaptersId(chaptersId);
        chapters.setCourseId(courseId);
        mmap.put("courseId", courseId);
        mmap.put("chaptersId", chaptersId);
        mmap.put("chapters",chaptersService.queryChaptersByCourseId(chapters));
        SysChapters chapters1 = chaptersService.queryChaptersByChaptersId(chapters);
        if(chapters1.getChaptersPurchase().equals("1")){
            //是否已购买
            if(StringUtils.isNotNull(user) && mycourseService.selectMycoursetByUserIdAndCoureId(courseId, user.getUid()) == 1){
                mmap.put("videore",chapters1.getChaptersUrl());
                mmap.put("hidden",false);
                return prefix;
            }else{
                mmap.put("videore",null);
                mmap.put("hidden",true);
                return prefix;
            }
        }
        mmap.put("hidden",false);
        mmap.put("videore",chapters1.getChaptersUrl());
        return prefix;
    }



    @GetMapping("/add/{id}")
    public String add(@PathVariable("id") Long chaptersid, ModelMap mmap){
        mmap.put("addchaptersid", chaptersid);
        return prefix + "/add";
    }

    @RequiresPermissions("curriculum:chapter:list")
    @PostMapping("/list/{id}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("id")Long chaptersid, SysChapters chapters)
    {
        startPage();  // 此方法配合前端完成自动分页
        chapters.setCourseId(chaptersid);
        List<SysChapters> list = chaptersService.selectChaptersList(chapters);
        return getDataTable(list);
    }

}

