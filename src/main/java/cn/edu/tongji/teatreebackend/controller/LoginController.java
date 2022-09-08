package cn.edu.tongji.teatreebackend.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.teatreebackend.service.Implement.JasyptUtilService;
import cn.edu.tongji.teatreebackend.service.Implement.LoginServiceImplement;
import cn.edu.tongji.teatreebackend.service.LoginService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Resource
    LoginService loginServiceImplement;

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
    public ResponseEntity<HashMap> doLogin(
            @RequestBody HashMap<String,String> param
            ){
        try {
            return new ResponseEntity<>(loginServiceImplement.doLogin(param.get("userName"),param.get("passWord")),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    // 查询登录状态，浏览器访问： http://localhost:8100/api/user/isLogin
    @RequestMapping(value = "isLogin",method = RequestMethod.GET)
    public Boolean isLogin() {
        return StpUtil.isLogin();
    }

    @RequestMapping(value = "logOut",method = RequestMethod.GET)
    public Boolean logOut(){
        try{
            StpUtil.logout();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}

