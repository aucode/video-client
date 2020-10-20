package com.shiro.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * (课程表)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysCourse {

    private static final long serialVersionUID=1L;

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

    /**
     * 类型id

     */
    private Long classId;

    /**
     * 用户名

     */
    private String userName;

    /**
     * 课程类型名

     */
    private String className;






    /**
     * 课程价格id
     */
    private Long pricesId;

    /**
     * 课程价格

     */
    private Float coutsePrices;

    /**
     * 折扣,0:无折扣，1:有折扣
     */
    private String coutseDiscounted;

    /**
     * 优惠价格,1折，2折 ..........
     */
    private Float discountedPrice;

    /**
     * 用户id

     */
    private Integer userId;

}
