package com.uece.trabalhofilme.repository;

import com.uece.trabalhofilme.entity.avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface avaliacaoRepository extends JpaRepository<avaliacao,Integer> {
}
