package com.shiro.demo.dao;


import com.shiro.demo.pojo.SysShoppingCart;

import java.util.List;


/**
 * <p>
 * (购物车) Mapper 接口
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysShoppingCartMapper {

    List<SysShoppingCart> selectShoppingCartListcarid(int uid);

    List<SysShoppingCart> selectShoppingCartList(int userId);

    int addCartInfo(SysShoppingCart shoppingCart);

    List<SysShoppingCart> selectCarByCarid(Long cartId,int id);

    List<SysShoppingCart> selectCar(Long cartId,int id);

    int deleteCartInfo(SysShoppingCart shoppingCart);

    int deleteCartInfoByUid(Integer Uid);



}
