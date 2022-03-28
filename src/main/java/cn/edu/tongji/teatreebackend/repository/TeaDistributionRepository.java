package cn.edu.tongji.teatreebackend.repository;

import cn.edu.tongji.teatreebackend.entity.TeaDistributionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeaDistributionRepository extends JpaRepository<TeaDistributionEntity,
        Integer> {

}
