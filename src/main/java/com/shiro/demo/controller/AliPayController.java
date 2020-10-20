package com.shiro.demo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import com.shiro.demo.config.AlipayConfig;
import com.shiro.demo.pojo.SysShoppingCart;
import com.shiro.demo.pojo.User;
import com.shiro.demo.service.SysMycourseService;
import com.shiro.demo.service.SysShoppingCartService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Project springboot-alipay-sandbox
 * @Description: AliPayController
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-07-15 10:53
 */
@Controller
public class AliPayController  extends BaseController{
    @Autowired
    private SysMycourseService mycourseService;
    /**
     * 支付请求路径
     * @param req
     * @param modelMap
     * @param rep
     * @throws AlipayApiException
     * @throws IOException
     */
    @RequestMapping(value = "pay")
    public void pay(int uid,HttpServletRequest req, HttpServletResponse rep, String courseId, String Paymethod,
                    ModelMap modelMap,Integer total) throws AlipayApiException, IOException {
        //获得初始化的AlipayClient
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do","2016072200101XXXX","请复制第1步中生成的密钥中的商户应用私钥","json","utf-8","沙箱环境RSA2支付宝公钥","RSA2");
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type);

        req.setAttribute("uid", uid);
        req.setAttribute("courseId", courseId);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = courseId;
        String out_trade_no = UUID.randomUUID().toString().replace("-","");
        //付款金额，必填  (随机生成 0-1000)
        String total_amount =String.valueOf(total);
        //订单名称，必填
        String subject = "课程购买";
        //购买课程编号

        //商品描述，可空

        String body = "";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no+"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"course\":\""+ uid +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        rep.setContentType("text/html;charset=" + AlipayConfig.charset);
        rep.getWriter().write(result);//直接将完整的表单html输出到页面
        rep.getWriter().flush();
        rep.getWriter().close();

    }



    @Autowired
    private SysShoppingCartService shoppingCartService;

    /**
     * 回调路径return_url
     * @param request
     * @param response
     * @throws AlipayApiException
     * @throws
     */
    @RequestMapping("return_url.view")
//    @ResponseBody
    public String returnUrl(HttpServletRequest request, HttpServletResponse response,ModelMap modelMap) throws AlipayApiException,
            UnsupportedEncodingException, UnsupportedEncodingException {

        System.out.println("returnUrl");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,AlipayConfig.sign_type);
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            request.setAttribute("out_trade_no", out_trade_no);
            request.setAttribute("trade_no", trade_no);
            request.setAttribute("total_amount", total_amount);


            System.out.println("订单处理：系统订单号" + out_trade_no + "支付宝交易号：" + trade_no);


        }else{
            request.setAttribute("reason", "验签失败");
        }
        request.setAttribute("signVerified", signVerified);

//        return "redirect:http://114.116.226.207/mycourse/pay-success";
        return "redirect:http://bjxxby.com/mycourse/pay-success";
    }


    /**
     * 异步回调路径 notify_url
     * @param request
     * @param response
     * @throws AlipayApiException
     * @throws
     */
    @RequestMapping("notify_url.view")
    public void notify_url(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, IOException {

        System.out.println("notify_url");
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        //boolean AlipaySignature.rsaCheckV1(Map<String, String> params, String publicKey, String charset, String sign_type)
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,AlipayConfig.sign_type);
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");


            //课程编号
            String course_on = new String(request.getParameter("course_on").getBytes("ISO-8859-1"),"UTF-8");

            request.setAttribute("out_trade_no", out_trade_no);
            request.setAttribute("trade_no", trade_no);
            request.setAttribute("total_amount", total_amount);
            request.setAttribute("course_on", course_on);


            System.out.println("订单处理：系统订单号" + out_trade_no + "支付宝交易号：" + trade_no);
            //系统处理根据支付宝回调更改订单状态或者其他关联表的数据
            //自己写逻辑业务判断
          /*  OrderInfo order = payService.findOneByTradeCode(out_trade_no);
            if(order == null){
                signVerified = false;
                request.setAttribute("signVerified", signVerified);
                request.setAttribute("reason", "商户订单号不存在");
                System.out.println("系统订单："+ out_trade_no + "不存在。");
            }else{
                if(!order.getMoney().toString().equals(total_amount)){
                    signVerified = false;
                    request.setAttribute("signVerified", signVerified);
                    request.setAttribute("reason", "付款金额不对");
                    return "notify_url";
                }
                if(order.getTradeStatus() == 1){//判断当前订单是否已处理，避免重复处理
                    log.info("系统订单："+ out_trade_no + "无需重复处理。");
                }else{
                    order.setTradeStatus(1);//修改订单状态为已支付
                    Date payedAt = new Date();
                    order.setTransactionId(trade_no);
                    order.setPayedAt(payedAt);
                    payService.payOrder(order);
                    System.out.println("系统订单："+ out_trade_no + "成功支付。");
                }
            }
*/
        }else{
            request.setAttribute("reason", "验签失败");
        }
        request.setAttribute("signVerified", signVerified);


        response.setContentType("text/html;charset=" + AlipayConfig.charset);
        response.getWriter().write("success");//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();




    }

}
