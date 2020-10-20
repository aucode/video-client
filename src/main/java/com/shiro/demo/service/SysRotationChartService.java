package com.shiro.demo.service;


import com.shiro.demo.pojo.SysRotationChart;

import java.util.List;

/**
 * @Project ruoyi
 * @Description: SysRotationChartService
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-30 22:56
 */

public interface SysRotationChartService {
    int add(SysRotationChart sysRotationChart);

    List<SysRotationChart> selectRotationChartList();

    SysRotationChart selectRotationChartById(Integer ids);

    Integer delectRotationChartById(Integer ids);
}
