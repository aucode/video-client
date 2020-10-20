package com.shiro.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * (课程类型)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysCourseClass {

    private static final long serialVersionUID=1L;

    /**
     * 类型id
     */
    private Long classId;

    /**
     * 类型名称
     */
    private String className;

    private List<SysQuestionLibrary> questionLibrary;

}
