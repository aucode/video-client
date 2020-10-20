package com.shiro.demo.service.impl;

import com.shiro.demo.dao.SysQuestionLibraryMapper;
import com.shiro.demo.pojo.SysApplicationQuestions;
import com.shiro.demo.pojo.SysQuestionLibrary;
import com.shiro.demo.pojo.SysSelectOptions;
import com.shiro.demo.pojo.SysSelectTopic;
import com.shiro.demo.service.SysQuestionLibraryService;
import com.shiro.demo.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * (题库表) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysQuestionLibraryServiceImpl implements SysQuestionLibraryService {

    @Autowired
    private SysQuestionLibraryMapper questionLibraryMapper;



    @Override
    public List<SysQuestionLibrary> selectQuestionLibraryList(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.selectQuestionLibraryList(questionLibrary);
    }

    @Override
    public int addQuestionLibraryInfo(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.addQuestionLibraryInfo(questionLibrary);
    }

    @Override
    public SysQuestionLibrary selectQuestionLibraryById(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.selectQuestionLibraryById(questionLibrary);
    }

    @Override
    public int editSaveQuestionLibraryInfo(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.editSaveQuestionLibraryInfo(questionLibrary);
    }
    /**
     * 获取题库中所有的选择题
     * @param questionLibrary
     * @return
     */
    @Override
    public List<SysQuestionLibrary> getLibraryLists(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.getLibraryLists(questionLibrary);
    }

    @Override
    public List<SysApplicationQuestions> getLibraryapplicationLists(SysQuestionLibrary questionLibrary) {
        return questionLibraryMapper.getLibraryapplicationLists(questionLibrary);
    }

    @Override
    public List<SysQuestionLibrary> queryAllQuestionLibrary() {
        return questionLibraryMapper.queryAllQuestionLibrary();
    }

}
