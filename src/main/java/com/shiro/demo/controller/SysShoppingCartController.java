package com.shiro.demo.controller;


import com.shiro.demo.pojo.SysCourse;
import com.shiro.demo.pojo.SysShoppingCart;
import com.shiro.demo.pojo.User;
import com.shiro.demo.service.SysCourseService;
import com.shiro.demo.service.SysShoppingCartService;
import com.shiro.demo.utils.AjaxResult;
import com.shiro.demo.utils.StringUtils;
import com.shiro.demo.utils.page.TableDataInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * (购物车) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("shopping")
public class SysShoppingCartController extends BaseController {

    private String prefix = "shopping";

    @Autowired
    private SysShoppingCartService shoppingCartService;

    @Autowired
    private SysCourseService courseService;

    @RequestMapping("/toProfile")
    public String profile(ModelMap modelMap) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        modelMap.put("user",user);
        modelMap.put("error",false);
        return prefix+"/profile";
    }


    /**
     * 我的购物车
     * @return
     */
    @GetMapping("/mycart")
    public String toMyCart(ModelMap modelMap){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNull(user)){
            return "page/login";
        }
        long userUid = (int)user.getUid();
        List<SysShoppingCart> list = shoppingCartService.selectShoppingCartList(userUid);
        modelMap.put("cart",list);
        return prefix + "/cart";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Long cartId)
    {
        startPage();  // 此方法配合前端完成自动分页
        List<SysShoppingCart> list = shoppingCartService.selectShoppingCartList(cartId);
        return getDataTable(list);
    }


    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(int id,SysShoppingCart shoppingCart,ModelMap modelMap)
    {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotNull(user)){
            long courseId = (int)id;

            List<SysShoppingCart> sysShoppingCarts = shoppingCartService.selectCarByCarid(courseId, user.getUid());
            List<SysShoppingCart> selectCar = shoppingCartService.selectCar(courseId, user.getUid());
            if (sysShoppingCarts.size()==0){
                if(selectCar.size()==0){

                    shoppingCart.setUserId(user.getUid());
                    shoppingCart.setCourseId(courseId);
                    return toAjax(shoppingCartService.addCartInfo(shoppingCart));
                }else{
                    return error("该课程已加入购物车！");
                }
            }else {
                return error("该课程已购买！");
            }

        }
        return error("未登录，请前往登录！");
    }
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(SysShoppingCart shoppingCart)
    {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotNull(user)){
            return toAjax(shoppingCartService.deleteCartInfo(shoppingCart));
        }
        return error("未登录，请前往登录！");
    }


}

