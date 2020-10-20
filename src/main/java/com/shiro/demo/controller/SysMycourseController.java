package com.shiro.demo.controller;



import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.PageInfo;
import com.shiro.demo.config.AlipayConfig;
import com.shiro.demo.pojo.SysMycourse;
import com.shiro.demo.pojo.SysShoppingCart;
import com.shiro.demo.pojo.User;
import com.shiro.demo.service.SysMycourseService;
import com.shiro.demo.service.SysShoppingCartService;
import com.shiro.demo.utils.AjaxResult;
import com.shiro.demo.utils.AliPayUtil;
import com.shiro.demo.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.shiro.demo.utils.AjaxResult.warn;

/**
 * <p>
 * (我的课程) 前端控制器
 * </p>
 *
 * @author Du Yi Code
 * @since 2020-07-28
 */
@Controller
@RequestMapping("mycourse")
public class SysMycourseController extends BaseController {

    private String prefix = "shopping";

    @Autowired
    private SysMycourseService mycourseService;


    @Autowired
    private SysShoppingCartService shoppingCartService;

    @GetMapping("/my-course")
    public String toMyCourseIndex(ModelMap modelMap){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        modelMap.put("userid",user.getUid());
        modelMap.put("mycourse",mycourseService.selectMycoursetList(1, 6, user.getUid()));
        return prefix + "/mycourse";
    }

    @GetMapping("/pay-success")
    public String PaySuccess(ModelMap modelMap){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<SysShoppingCart> sysShoppingCarts = shoppingCartService.selectShoppingCartListcarid(user.getUid());
        Long [] courseId = new Long[sysShoppingCarts.size()];
        for(int i = 0;i<sysShoppingCarts.size();i++){
            courseId[i] = sysShoppingCarts.get(i).getCourseId();

        }
        mycourseService.addMycourseInfo(courseId,user.getUid());

        modelMap.put("userid",user.getUid());
        modelMap.put("mycourse",mycourseService.selectMycoursetList(1, 6, user.getUid()));
        return prefix + "/mycourse";
    }



    @GetMapping("/list")
    public String list(int page,ModelMap modelMap)
    {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PageInfo<SysMycourse> sysMycoursePageInfo = mycourseService.selectMycoursetList(page, 6, user.getUid());
        modelMap.put("mycourse",mycourseService.selectMycoursetList(page, 6, user.getUid()));
        return prefix + "/mycourse";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Long[] courseId,String Paymethod,ModelMap modelMap)
    {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(StringUtils.isNotNull(user)){
            for(Long courseid : courseId){
                String nameStr = mycourseService.selectMycoursetNameByUserIdAndCoureId(courseid, user.getUid());
                if(StringUtils.isNotNull(nameStr)){
                    modelMap.put("msg","课程：" + nameStr + ",您已经购买请勿重复购买。");
                    return error(AjaxResult.Type.WARN,"课程：" + nameStr + ",您已经购买请勿重复购买。");
                }
            }
            return toAjax(mycourseService.addMycourseInfo(courseId,user.getUid()));
        }
        redirect("/login");
        return error("未登录，请前往登录！");
    }
}

