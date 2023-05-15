package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.HoaDonEntity;
import com.csdlpt.CRUD.Model.KhachHangEntity;
import com.csdlpt.CRUD.Model.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDonEntity, String> {
    @Query(value = "select * from hoadon where id_khanh_hang = ?1", nativeQuery = true)
    List<HoaDonEntity> getAllByKhachHang(String idKhachHang);

    @Query(value = "select * from hoadon where id_nhan_vien = ?1", nativeQuery = true)
    List<HoaDonEntity> getAllByNhanVien(String idNhanVien);
}
