package com.shiro.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * (题库表)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysQuestionLibrary {

    private static final long serialVersionUID=1L;

    /**
     * 题库id
     */
    private Long libraryId;

    /**
     * 题目
     */
    private String title;
    /**
     * 类型id
     */
    private Long classId;




}
