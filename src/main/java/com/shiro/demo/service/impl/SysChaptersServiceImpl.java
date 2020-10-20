package com.shiro.demo.service.impl;


import com.shiro.demo.dao.SysChaptersMapper;
import com.shiro.demo.pojo.SysChapters;
import com.shiro.demo.service.SysChaptersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (章节表) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysChaptersServiceImpl implements SysChaptersService {
    @Autowired
    private SysChaptersMapper chaptersMapper;

    @Override
    public int saveChatersInfoByCourseId(SysChapters chapters) {
        return chaptersMapper.saveChatersInfoByCourseId(chapters);
    }

    @Override
    public List<SysChapters> selectChaptersList(SysChapters chapters) {
        return chaptersMapper.selectChaptersList(chapters);
    }

    @Override
    public List<SysChapters> queryChaptersByCourseId(SysChapters chapters) {
        return chaptersMapper.queryChaptersByCourseId(chapters);
    }

    @Override
    public SysChapters queryChaptersByChaptersId(SysChapters chapters) {
        return chaptersMapper.queryChaptersByChaptersId(chapters);
    }
}
