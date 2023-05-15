package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.SanBayEntity;
import com.csdlpt.CRUD.Model.TuyenBayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface TuyenBayRepository extends JpaRepository<TuyenBayEntity, String> {
    @Query(value = "select * from tuyenbay "
                + "where id_sb_den = :keyword or id_sb_di = :keyword",
                nativeQuery = true)
    List<TuyenBayEntity> getAllBySanBay(@Param("keyword") String keyword);
}
