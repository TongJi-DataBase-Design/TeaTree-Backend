package cn.edu.tongji.teatreebackend.controller;

import cn.edu.tongji.teatreebackend.entity.TeaDistributionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

//    @RequestMapping(value = "/distribution", method = RequestMethod.POST)
//    public ResponseEntity<Boolean> createArticleInTeaDistribution(
//            HashMap param
//    ){
//        return new ResponseEntity<>(true, HttpStatus.OK);
//    }
}
