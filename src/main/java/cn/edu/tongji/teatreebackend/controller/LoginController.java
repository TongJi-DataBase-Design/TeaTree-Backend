package cn.edu.tongji.teatreebackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.teatreebackend.service.Implement.JasyptUtilService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 控制和 Login 相关的逻辑
 *
 * @author 梁乔
 * @date 2022/3/31 21:38
 */

@RestController
@RequestMapping("/api/user/")
public class LoginController {


    @Deprecated
    @ApiOperation("Customer login")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "success!"),
                    @ApiResponse(code = 401, message = "Wrong password or user not exist")
            }
    )

    // 测试登录，浏览器访问： http://localhost:8100/api/user/doLogin
    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public String doLogin(
            @RequestBody HashMap<String,String> param
            ){

        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(param.get("userName")) && "123456".equals(param.get("passWord"))) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8100/api/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}

