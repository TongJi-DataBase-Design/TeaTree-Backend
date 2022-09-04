package cn.edu.tongji.teatreebackend.repository;

import cn.edu.tongji.teatreebackend.entity.TeaDistributionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeaDistributionRepository extends JpaRepository<TeaDistributionEntity,
        Integer> {
    TeaDistributionEntity findFirstById(int id);

    @Query(value = "select max(id) + 1 from tea_distribution" , nativeQuery = true)
    int findNewArticleId();

    List<TeaDistributionEntity> findAllByIsTopOrderByArticleTimeDesc(int isTop, Pageable pageable);
    @Query(value = "select count(id) from tea_distribution", nativeQuery = true)
    int getTotalPostAmount();

    @Query(value = "select distinct tea_direction from tea_distribution where ", nativeQuery = true)
    List<String> getTeaDirections(int articleType);
}
