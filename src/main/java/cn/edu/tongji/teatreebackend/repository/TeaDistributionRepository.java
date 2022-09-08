package cn.edu.tongji.teatreebackend.repository;

import cn.edu.tongji.teatreebackend.entity.TeaDistributionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface TeaDistributionRepository extends JpaRepository<TeaDistributionEntity,
        Integer> {
    TeaDistributionEntity findFirstById(int id);

    @Query(value = "select max(id) + 1 from tea_distribution" , nativeQuery = true)
    int findNewArticleId();

    List<TeaDistributionEntity> findAllByArticleTitleLikeAndArticleTypeAndTeaDirectionIn(String articleTitle, int articleType, List<String> teaDirections, Pageable pageable);

    @Query(value = "select distinct tea_direction from tea_distribution where article_type = ?1", nativeQuery = true)
    List<String> getTeaDirections(int articleType);
    
    @Query(value = "select * from tea_distribution where article_type = ?1 and is_top = 1", nativeQuery = true)
    List<TeaDistributionEntity> getTopArticles(int articleType);

    @Query(value = "select * from tea_distribution where article_type = ?1 order by article_time limit ?2", nativeQuery = true)
    List<TeaDistributionEntity> getLatestArticles(int articleType, int articleNumbers);
}
