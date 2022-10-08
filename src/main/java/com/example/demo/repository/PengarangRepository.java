package com.example.demo.repository;

import com.example.demo.entity.Pengarang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PengarangRepository extends JpaRepository<Pengarang, Long> {
}
