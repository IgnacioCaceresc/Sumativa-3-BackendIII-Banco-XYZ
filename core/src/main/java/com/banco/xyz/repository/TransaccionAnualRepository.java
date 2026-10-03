package com.banco.xyz.repository;

import com.banco.xyz.model.entity.TransaccionAnual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionAnualRepository extends JpaRepository<TransaccionAnual, Integer> {
}
