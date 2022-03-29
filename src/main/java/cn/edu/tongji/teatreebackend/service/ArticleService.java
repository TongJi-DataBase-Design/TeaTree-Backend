package cn.edu.tongji.teatreebackend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface ArticleService {

    HashMap<String, String> getArticleInTeaDistribution(int id);

    boolean createArticleInTeaDistribution(HashMap<String,String> param);
}
