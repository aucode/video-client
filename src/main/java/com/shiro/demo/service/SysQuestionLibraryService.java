package com.shiro.demo.service;

import com.shiro.demo.pojo.SysApplicationQuestions;
import com.shiro.demo.pojo.SysQuestionLibrary;
import com.shiro.demo.pojo.SysSelectTopic;

import java.util.List;

/**
 * <p>
 * (题库表) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysQuestionLibraryService {
    List<SysQuestionLibrary> selectQuestionLibraryList(SysQuestionLibrary questionLibrary);

    int addQuestionLibraryInfo(SysQuestionLibrary questionLibrary);

    SysQuestionLibrary selectQuestionLibraryById(SysQuestionLibrary questionLibrary);

    int editSaveQuestionLibraryInfo(SysQuestionLibrary questionLibrary);

    /**
     * 获取题库中所有的选择题
     * @param questionLibrary
     * @return
     */
    List<SysQuestionLibrary> getLibraryLists(SysQuestionLibrary questionLibrary);

    List<SysApplicationQuestions> getLibraryapplicationLists(SysQuestionLibrary questionLibrary);

    List<SysQuestionLibrary> queryAllQuestionLibrary();



}
