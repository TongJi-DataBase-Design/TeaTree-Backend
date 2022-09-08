package cn.edu.tongji.teatreebackend.controller;

import cn.edu.tongji.teatreebackend.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
     * @return 前5个帖子
     */
    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getHomepageActivityArticles() {
        return new ResponseEntity<>(articleService.getHomepageArticles(5),
                HttpStatus.OK);
    }

    /**
     * 获取首页古茶文化的帖子
     * @return 前5个帖子
     */
    @RequestMapping(value = "/culture", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getHomepageCultureArticles() {
        return new ResponseEntity<>(articleService.getHomepageArticles(3),
                HttpStatus.OK);
    }

    /**
     * 获取首页古茶产业的帖子
     * @return 前5个帖子
     */
    @RequestMapping(value = "/industry", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getHomepageIndustryArticles() {
        return new ResponseEntity<>(articleService.getHomepageArticles(4),
                HttpStatus.OK);
    }

    /**
     * 获取全局置顶帖子
     */
    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public ResponseEntity<List> getHomepageTopArticles() {
        return new ResponseEntity<>(articleService.getHomepageTopArticles(),
                HttpStatus.OK);
    }

    /**
     * 添加新的全局置顶帖子
     */
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public ResponseEntity<String> addHomepageTopArticles(int articleId) {
        return new ResponseEntity<>(articleService.addHomepageTopArticle(articleId),
                HttpStatus.OK);
    }

    /**
     * 删除指定的全局置顶的帖子
     */
    @RequestMapping(value = "/top", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteHomepageTopArticle(int articleId) {
        return new ResponseEntity<>(articleService.deleteHomepageTopArticle(articleId),
                HttpStatus.OK);
    }
}
