package com.shiro.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * (我的课程)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMycourse  {

    private static final long serialVersionUID=1L;

    /**
     * 我的课程id
     */
    private Long mycourseId;

    /**
     * 用户id

     */
    private Integer userId;

    /**
     * 课程id

     */
    private Long courseId;

    /**
     * 课程名

     */
    private String courseName;

    /**
     * 课程封面

     */
    private String courseUrl;

    /**
     * 课程介绍

     */
    private String courseDescription;

    /**
     * 课程讲师

     */
    private Long courseUserId;


}
