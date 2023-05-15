package com.csdlpt.CRUD.Repository;

import com.csdlpt.CRUD.Model.SanBayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanBayRepository extends JpaRepository<SanBayEntity, String> {
}
