package cn.edu.tongji.teatreebackend.repository;

import cn.edu.tongji.teatreebackend.entity.TeaDistributionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeaDistributionRepository extends JpaRepository<TeaDistributionEntity,
        Integer> {
    TeaDistributionEntity findFirstById(int id);

    @Query(value = "select max(id) + 1 from tea_distribution" , nativeQuery = true)
    int findNewArticleId();
}
