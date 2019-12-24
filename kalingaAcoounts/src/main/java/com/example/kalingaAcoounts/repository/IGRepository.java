package com.example.kalingaAcoounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kalingaAcoounts.entity.IG;


@Repository
public interface IGRepository extends JpaRepository<IG, Integer>{

	IG findByigName(String igName);

}
