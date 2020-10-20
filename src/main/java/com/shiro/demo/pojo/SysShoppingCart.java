package com.shiro.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * (购物车)
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysShoppingCart {

    private static final long serialVersionUID=1L;

    /**
     * 购物车id
     */
      private Long cartId;

    /**
     * 用户id

     */
    private int userId;

    /**
     * 课程id

     */
    private Long courseId;

    /** 用户名称 */
    private String userName;

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
     * 课程价格

     */
    private Long coutsePrices;
    /**
     * 优惠价格

     */
    private Long discountedPrice;
}
