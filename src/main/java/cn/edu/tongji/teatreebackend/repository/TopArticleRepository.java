package cn.edu.tongji.teatreebackend.repository;

import cn.edu.tongji.teatreebackend.entity.TopArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopArticleRepository extends JpaRepository<TopArticleEntity, Integer> {
    @Query(value = "select * from top_article" , nativeQuery = true)
    List<TopArticleEntity> getAllTopArticles();
}
