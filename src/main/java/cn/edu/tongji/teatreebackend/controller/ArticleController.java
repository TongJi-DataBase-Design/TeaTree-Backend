package cn.edu.tongji.teatreebackend.controller;

import cn.edu.tongji.teatreebackend.Dtos.SearchConditionsDto;
import cn.dev33.satoken.stp.StpUtil;
import cn.edu.tongji.teatreebackend.entity.TeaDistributionEntity;
import cn.edu.tongji.teatreebackend.service.ArticleService;
import cn.edu.tongji.teatreebackend.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ArticleController类
 *
 * 处理文章所有基础的增删改
 *
 * @author 汪明杰
 * @date 2022/3/29 0:19
 */

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @Resource
    LoginService loginService;

    /**
     * 根据id获取文章全部内容
     * @param id
     * @return 文章内容
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public ResponseEntity<TeaDistributionEntity> getArticleInDistribution(
            @RequestParam int id
    ){
        return new ResponseEntity<>(articleService.getArticleInTeaDistribution(id),
                HttpStatus.OK);
    }

    /**
     * 根据文章种类获取文章类别
     * @param articleType
     * @return 文章类别数组
     */
    @RequestMapping(value = "/articleTypeGroup", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getArticleGroups(
            @RequestParam int articleType
    ){
        return new ResponseEntity<>(articleService.getArticleGroupsByArticleType(articleType),
                HttpStatus.OK);
    }

    /**
     * 根据pageNo页码,页大小,关键字,文章种类获取当前页的帖子id和帖子总数
     * @return
     */
    @RequestMapping(value = "/distribution/list", method = RequestMethod.POST)
    public ResponseEntity<Map> getArticleListInDistribution(
            @RequestBody SearchConditionsDto searchConditions
            ){
        return new ResponseEntity<>(articleService.getArticleListInDistribution(searchConditions),
                HttpStatus.OK);
    }

    /**
     * 根据id在古茶分布板块获取文章预览信息
     * @param id
     * @return 文章预览信息
     */
    @RequestMapping(value = "/distribution/preview", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getArticlePreviewInDistribution(
            @RequestParam int id
    ){
        return new ResponseEntity<>(articleService.getArticlePreviewInTeaDistribution(id),
                HttpStatus.OK);
    }

    /**
     * 更改板块中文章置顶状态
     * @param id
     * @return
     */
    @RequestMapping(value = "/top", method = RequestMethod.POST)
    public ResponseEntity<Boolean> changeArticleTopStatus(
            @RequestParam int id
    ) {
        if (StpUtil.isLogin()) {
            return new ResponseEntity<>(articleService.changeArticleTopStatus(id),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    /**
     * 增加古茶分布板块中id的文章的 点击量
     * @param id
     * @return 增加成功与否
     */
    @RequestMapping(value = "/distribution/click", method = RequestMethod.GET)
    public ResponseEntity<Boolean> increaseArticleClickNumInDistribution(
            @RequestParam int id
    ){
        return new ResponseEntity<>(articleService.increaseArticleClickNumInDistribution(id),
                HttpStatus.OK);
    }

    /**
     * 创建文章
     * @param param
     * @return 新帖子id
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> createArticleInTeaDistribution(
            @RequestBody HashMap<String,String> param
    ){
        if (StpUtil.isLogin()) {
            return new ResponseEntity<>(articleService.createArticleInTeaDistribution(param),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteArticleById(
            @RequestParam int id
    ) {
        if (StpUtil.isLogin()) {
            return new ResponseEntity<>(articleService.deleteArticleById(id),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }
    }

}
