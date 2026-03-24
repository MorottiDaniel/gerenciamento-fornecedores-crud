package com.morotti.fornecedores.repository;

import com.morotti.fornecedores.entity.FornecedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<FornecedoresEntity, Long> {
}
