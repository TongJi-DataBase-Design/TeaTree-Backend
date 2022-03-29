package cn.edu.tongji.teatreebackend.controller;

import cn.edu.tongji.teatreebackend.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

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
     * @return
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public ResponseEntity<HashMap> getArticleInDistribution(
            @RequestParam int id
    ){
        return new ResponseEntity<>(articleService.getArticleInTeaDistribution(id),
                HttpStatus.OK);
    }

    /**
     * 在古茶分布板块创建文章
     * @param param
     * @return
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.POST)
    public ResponseEntity<Boolean> createArticleInTeaDistribution(
            @RequestBody HashMap<String,String> param
    ){
        return new ResponseEntity<>(articleService.createArticleInTeaDistribution(param),
                HttpStatus.OK);
    }


}
