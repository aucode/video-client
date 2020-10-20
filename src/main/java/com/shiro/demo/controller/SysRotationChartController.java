package com.shiro.demo.controller;

import com.shiro.demo.pojo.SysRotationChart;
import com.shiro.demo.service.SysRotationChartService;
import com.shiro.demo.utils.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Project ruoyi
 * @Description: SysRotationChartController
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-30 23:01
 */
@Controller
public class SysRotationChartController extends BaseController {
    private String prefix = "curriculum/rotationchar";
    @Autowired
    private SysRotationChartService sysRotationChartService;

    @RequestMapping("rotation/char/v")
    public String rotationChar(){
        return prefix + "/index";
    }
    @PostMapping("rotation/char/list")
    @ResponseBody
    public TableDataInfo list(SysRotationChart sysCourse){
        startPage();
        List<SysRotationChart> list = sysRotationChartService.selectRotationChartList();
        return getDataTable(list);
    }


}
