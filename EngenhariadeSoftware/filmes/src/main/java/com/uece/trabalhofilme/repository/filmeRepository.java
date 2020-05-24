package com.uece.trabalhofilme.repository;

import com.uece.trabalhofilme.entity.filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface filmeRepository extends JpaRepository<filme, Integer> {
}
