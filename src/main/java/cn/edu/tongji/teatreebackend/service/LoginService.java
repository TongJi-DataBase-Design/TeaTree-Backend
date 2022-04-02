package cn.edu.tongji.teatreebackend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public interface LoginService {


    /**
     * 完成登录操作
     * @return api返回值
     */
    HashMap<String,Boolean> doLogin(String name,String passWord);
}
