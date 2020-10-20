package com.shiro.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 选择题表
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSelectTopic {

    private static final long serialVersionUID=1L;

    /**
     * 选择题id
     */
    private Long topicId;

    /**
     * 题目
     */
    private String title;

    /**
     * 解析解答
     */
    private String analyze;

    /**
     * 题库id
     */
    private Long libraryId;

    private List<SysSelectOptions> selectOptions;


}
