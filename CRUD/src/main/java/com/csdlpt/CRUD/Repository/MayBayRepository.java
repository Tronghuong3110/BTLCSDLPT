package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.MayBayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MayBayRepository extends JpaRepository<MayBayEntity, String> {
    Optional<MayBayEntity> findByIdAndTinhtrang(String maMayBay, String tinhTrang);
}
