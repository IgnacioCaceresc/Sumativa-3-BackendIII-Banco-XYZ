package com.banco.xyz.repository;

import com.banco.xyz.model.entity.InteresMensual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresMensualRepository extends JpaRepository<InteresMensual, String> {
}
