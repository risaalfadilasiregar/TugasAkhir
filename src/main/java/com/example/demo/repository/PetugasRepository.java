package com.example.demo.repository;

import com.example.demo.entity.Petugas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetugasRepository extends JpaRepository<Petugas, Long> {
}
