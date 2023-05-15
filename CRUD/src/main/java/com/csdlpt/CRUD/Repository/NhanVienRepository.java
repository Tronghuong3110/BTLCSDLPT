package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity, String> {
    @Query(value = "select * from nhanhvien where id_chi_nhanh = ?1", nativeQuery = true)
    List<NhanVienEntity> getAllByChiNhanh(String idChiNhanh);
}
