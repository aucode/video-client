package com.shiro.demo.service.impl;

import com.shiro.demo.dao.SysShoppingCartMapper;
import com.shiro.demo.pojo.SysCourse;
import com.shiro.demo.pojo.SysShoppingCart;
import com.shiro.demo.service.SysShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * (购物车) 服务实现类
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Service
public class SysShoppingCartServiceImpl implements SysShoppingCartService {

    @Autowired
    private SysShoppingCartMapper shoppingCartMapper;

    @Override
    public List<SysShoppingCart> selectShoppingCartList(Long cartId) {
        return shoppingCartMapper.selectShoppingCartList(cartId.intValue());
    }

    @Override
    public List<SysShoppingCart> selectShoppingCartListcarid(int uid) {
        return shoppingCartMapper.selectShoppingCartListcarid(uid);
    }

    @Override
    public int addCartInfo(SysShoppingCart shoppingCart) {
        return shoppingCartMapper.addCartInfo(shoppingCart);
    }

    @Override
    public int deleteCartInfo(SysShoppingCart shoppingCart) {
        return shoppingCartMapper.deleteCartInfo(shoppingCart);
    }

    @Override
    public List<SysShoppingCart> selectCar(Long cartId, int id) {
        return shoppingCartMapper.selectCar(cartId,id);
    }

    @Override
    public List<SysShoppingCart> selectCarByCarid(Long cartId,int id) {
        return shoppingCartMapper.selectCarByCarid(cartId,id);
    }
}
