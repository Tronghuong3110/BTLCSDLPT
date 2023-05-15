package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.ChiNhanhEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiNhanhRepository extends JpaRepository<ChiNhanhEntity, String> {
}
