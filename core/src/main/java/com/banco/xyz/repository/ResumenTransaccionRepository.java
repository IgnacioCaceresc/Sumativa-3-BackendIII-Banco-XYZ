package com.banco.xyz.repository;

import com.banco.xyz.model.entity.ResumenTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumenTransaccionRepository extends JpaRepository<ResumenTransaccion, String> {
}
