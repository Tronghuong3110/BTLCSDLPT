package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.VeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface VeRepository extends JpaRepository<VeEntity, String> {
    @Query(value = "select * from ve where id_hoa_don = ?1", nativeQuery = true)
    List<VeEntity> getAllByHoaDon(String idHoaDon);

    @Query(value = "select * from ve where id_chuyen_bay = ?1", nativeQuery = true)
    List<VeEntity> getAllByChuyenBay(String idChuyenBay);
}
