package cn.edu.tongji.teatreebackend.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public interface ArticleService {

    HashMap<String, String> getArticleInTeaDistribution(int id);

    HashMap<String, String> getArticlePreviewInTeaDistribution(int id);

    int createArticleInTeaDistribution(HashMap<String,String> param);

    boolean increaseArticleClickNumInDistribution(int id);

    Map<String,Object> getArticleListInDistribution(int pageNum, int pageSize, String keyword, int articleType);

    HashMap<String,Object> getArticleGroupsByArticleType(int articleType);
}
