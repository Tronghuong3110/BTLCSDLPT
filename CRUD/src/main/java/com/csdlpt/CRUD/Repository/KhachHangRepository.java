package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity, String> {
}
