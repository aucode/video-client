package com.shiro.demo.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * (应用题表）
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysApplicationQuestions {

    private static final long serialVersionUID=1L;

    /**
     * 应用id
     */
      private Long optionsId;

    /**
     * 题目
     */
    private String options;

    /**
     * 解析
     */
    private String analysis;

    /**
     * 题库id
     */
    private Long libraryId;



}
