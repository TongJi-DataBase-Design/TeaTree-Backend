package cn.edu.tongji.teatreebackend.controller;

import cn.edu.tongji.teatreebackend.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 首页相关的api
 */
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Resource
    ArticleService articleService;

    /**
     * 获取首页古茶动态的帖子
     * @return
     */
    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getHomepageActivityArticles() {
        return new ResponseEntity<>(articleService.getHomepageArticles(5),
                HttpStatus.OK);
    }
}
