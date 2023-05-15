package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.ChuyenBayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBayEntity, String> {
    @Query(value = "select * from chuyenbay where id_tuyen_bay = ?1", nativeQuery = true)
    List<ChuyenBayEntity> getALlByTuyenbay(String idTuyenBay);

    @Query(value = "select * from chuyenbay where id_may_bay = ?1", nativeQuery = true)
    List<ChuyenBayEntity> getALlByMaybay(String idMayBay);

}
