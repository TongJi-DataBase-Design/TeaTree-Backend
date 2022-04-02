package cn.edu.tongji.teatreebackend.service.Implement;

import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.teatreebackend.entity.TeaUserEntity;
import cn.edu.tongji.teatreebackend.repository.TeaUserRepository;
import cn.edu.tongji.teatreebackend.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.StyledEditorKit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *  LoginServiceImplement类
 * @author 梁乔
 * @date 2022/3/31 0:33
 */
@Service
public class LoginServiceImplement implements LoginService {

    @Resource
    TeaUserRepository teaUserRepository;

    /**
     * 进行登录操作
     * @param name 要登陆的用户名
     * @param passWord  要登陆的密码
     * @return 登录结果
     */
    @Override
    public HashMap<String, Boolean> doLogin(String name,String passWord) {
        HashMap<String, Boolean> result = new HashMap<>();
        Optional<TeaUserEntity> user = teaUserRepository.findByName(name);
        if(user.isPresent()){
            if(passWord.equals(JasyptUtilService.decyptPwd("jasypt", user.get().getPassword())))
            {
                StpUtil.login(user.get().getId());
                result.put("isLogin", true);
            }
        }
        else {
            result.put("isLogin", false);
        }
        return result;
    }

}
