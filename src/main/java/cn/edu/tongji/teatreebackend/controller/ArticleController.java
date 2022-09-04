package cn.edu.tongji.teatreebackend.controller;

import cn.edu.tongji.teatreebackend.service.ArticleService;
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

    /**
     * 根据id在古茶分布板块获取文章
     * @param id
     * @return 文章内容
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getArticleInDistribution(
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
     * 根据pageNum页码获取当前页的帖子id和帖子总数
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/distribution/list", method = RequestMethod.GET)
    public ResponseEntity<Map> getArticleListInDistribution(
            @RequestParam int pageNo
    ){
        return new ResponseEntity<>(articleService.getArticleListInDistribution(pageNo),
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
     * 在古茶分布板块创建文章
     * @param param
     * @return 新帖子id
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.POST)
    public ResponseEntity<Integer> createArticleInTeaDistribution(
            @RequestBody HashMap<String,String> param
    ){
        return new ResponseEntity<>(articleService.createArticleInTeaDistribution(param),
                HttpStatus.OK);
    }


}
