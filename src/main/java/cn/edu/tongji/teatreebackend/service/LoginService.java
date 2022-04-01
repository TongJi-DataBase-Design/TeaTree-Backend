package cn.edu.tongji.teatreebackend.service;

import org.springframework.stereotype.Service;


@Service
public interface LoginService {
    /**
     * 查看用户名和密码是否正确
     * @param userName 用户名
     * @param passWord 密码
     * @return 正确为真，错误为假
     */
    Boolean checkLogin(String userName,String passWord);
}
