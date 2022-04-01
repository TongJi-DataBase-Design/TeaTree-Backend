package cn.edu.tongji.teatreebackend.repository;

import cn.edu.tongji.teatreebackend.entity.TeaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeaUserRepository extends JpaRepository<TeaUserEntity,Integer> {
    Optional<TeaUserEntity> findByName(String name);
}
