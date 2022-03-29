package cn.edu.tongji.teatreebackend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ArticleService {

    boolean createArticleInTeaDistribution(HashMap<String,String> param);
}
