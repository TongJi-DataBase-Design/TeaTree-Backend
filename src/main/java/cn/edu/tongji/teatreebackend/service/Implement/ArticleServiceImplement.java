package cn.edu.tongji.teatreebackend.service.Implement;

import cn.edu.tongji.teatreebackend.entity.TeaDistributionEntity;
import cn.edu.tongji.teatreebackend.repository.TeaDistributionRepository;
import cn.edu.tongji.teatreebackend.service.ArticleService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ArticleServiceImplement类
 *
 * @author 汪明杰
 * @date 2022/3/29 0:33
 */

@Service
public class ArticleServiceImplement implements ArticleService {

    @Resource
    TeaDistributionRepository teaDistributionRepository;

    private static final int pageSize = 10;

    @Override
    public TeaDistributionEntity getArticleInTeaDistribution(int id){
        TeaDistributionEntity teaDistribution =
                teaDistributionRepository.findFirstById(id);
        if (teaDistribution == null) {
            return null;
        }
        return teaDistribution;
    }

    @Override
    public HashMap<String, String> getArticlePreviewInTeaDistribution(int id){
        TeaDistributionEntity teaDistribution =
                teaDistributionRepository.findFirstById(id);
        if (teaDistribution == null) {
            return null;
        }
        HashMap<String, String> res = new HashMap<>();
        res.put("title", teaDistribution.getArticleTitle());
        res.put("abstract", teaDistribution.getArticleAbstract());
        res.put("cover", teaDistribution.getArticleCover());
        res.put("clickNum", teaDistribution.getClickNum().toString());
        res.put("teaLocation", teaDistribution.getTeaDirection());
        res.put("teaType", teaDistribution.getTeaType());
        res.put("biologyTeaType", teaDistribution.getBiologyTeaType());
        res.put("articleType", String.valueOf(teaDistribution.getArticleType()));
        res.put("protectionArticleType", teaDistribution.getProtectionArticleType());
        res.put("cultureArticleType", teaDistribution.getCultureArticleType());
        res.put("industryArticleType", teaDistribution.getIndustryArticleType());
        res.put("activityArticleType", teaDistribution.getActivityArticleType());
        res.put("teaAge", String.valueOf(teaDistribution.getTeaAge()));
        res.put("time", teaDistribution.getArticleTime().toString());
        res.put("source", teaDistribution.getArticleSource());
        return res;
    }

    @Override
    public int createArticleInTeaDistribution(HashMap<String,String> param) {
        TeaDistributionEntity teaDistribution = new TeaDistributionEntity();
        // 获取当前文章的id
        int newId = teaDistributionRepository.findNewArticleId();
        teaDistribution.setId(newId);
        teaDistribution.setArticleTitle(param.get("title"));
        teaDistribution.setArticleAbstract(param.get("abstract"));
        teaDistribution.setArticleCover(param.get("cover"));
        teaDistribution.setArticleContent(param.get("content"));
        teaDistribution.setArticleSource(param.get("source"));
        teaDistribution.setArticleTime(new Timestamp(System.currentTimeMillis()));
        teaDistribution.setTeaDirection(param.get("teaLocation"));
        teaDistribution.setTeaType(param.get("teaType"));
        teaDistribution.setClickNum(0);
        teaDistribution.setIsTop(0);
        teaDistribution.setBiologyTeaType(param.get("biologyTeaType"));
        teaDistribution.setArticleType(Integer.valueOf(param.get("articleType")));
        teaDistribution.setProtectionArticleType(param.get("protectionArticleType"));
        teaDistribution.setCultureArticleType(param.get("cultureArticleType"));
        teaDistribution.setIndustryArticleType(param.get("industryArticleType"));
        teaDistribution.setActivityArticleType(param.get("activityArticleType"));
        teaDistribution.setTeaAge(Integer.valueOf(param.get("teaAge")));


        teaDistributionRepository.save(teaDistribution);

        return newId;
    }

    @Override
    public boolean increaseArticleClickNumInDistribution(int id){
        TeaDistributionEntity teaDistribution =
                teaDistributionRepository.findFirstById(id);
        teaDistribution.setClickNum((teaDistribution.getClickNum() + 1));
        teaDistributionRepository.save(teaDistribution);
        return true;
    }

    @Override
    public Map<String,Object> getArticleListInDistribution(int pageNum){
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        List<TeaDistributionEntity> teaDistributionEntities =
                teaDistributionRepository
                        .findAllByIsTopOrderByArticleTimeDesc(0, pageable);
        // 获取结果id
        List<Integer> postIds = new ArrayList<>();
        teaDistributionEntities.forEach((TeaDistributionEntity item)->{
            postIds.add(item.getId());
        });
        Map<String, Object> res = new HashMap<>();
        res.put("id", postIds);
        res.put("total", teaDistributionRepository.getTotalPostAmount());

        return res;
    }

    /**
     * 获取首页中制定类别的帖子,返回5个
     * @param articleType
     * @return
     */
    @Override
    public HashMap<String, Object> getHomepageArticles(int articleType) {
        HashMap<String, Object> res = new HashMap<>();

        List<String> articleTitles = new ArrayList<>();
        List<String> articleCovers = new ArrayList<>();
        List<String> articleTimes = new ArrayList<>();
        List<String> articleIds = new ArrayList<>();

        // 查看top的帖子
        List<TeaDistributionEntity> toppestArticles =
                teaDistributionRepository.getTopArticles(articleType);
        for (int i = 0; i < 5 && i < toppestArticles.size(); ++i) {
            articleTitles.add(toppestArticles.get(i).getArticleTitle());
            articleCovers.add(toppestArticles.get(i).getArticleCover());
            articleTimes.add(toppestArticles.get(i).getArticleTime().toString());
            articleIds.add(String.valueOf(toppestArticles.get(i).getId()));
        }
        // 获取按时间排序前5的帖子
        List<TeaDistributionEntity> latestArticles =
                teaDistributionRepository.getLatestArticles(articleType,
                        5 - articleTitles.size());
        latestArticles.forEach((TeaDistributionEntity article)->{
            articleTitles.add(article.getArticleTitle());
            articleCovers.add(article.getArticleCover());
            articleTimes.add(article.getArticleTime().toString());
            articleIds.add(String.valueOf(article.getId()));
        });

        res.put("article_titles", articleTitles);
        res.put("article_covers", articleCovers);
        res.put("article_times", articleTimes);
        res.put("article_ids", articleIds);
        return res;
    }
}
