package com.shiro.demo.service;

import com.shiro.demo.pojo.SysCourse;
import com.shiro.demo.pojo.SysShoppingCart;

import java.util.List;

/**
 * <p>
 * (购物车) 服务类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
public interface SysShoppingCartService {


    List<SysShoppingCart> selectShoppingCartList(Long cartId);

    List<SysShoppingCart> selectShoppingCartListcarid(int uid);

    int addCartInfo(SysShoppingCart shoppingCart);

    int deleteCartInfo(SysShoppingCart shoppingCart);

    List<SysShoppingCart> selectCar(Long cartId,int id);

    List<SysShoppingCart> selectCarByCarid(Long cartId,int id);


}
