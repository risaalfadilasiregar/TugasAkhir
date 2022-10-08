package com.example.demo.repository;

import com.example.demo.entity.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeminjamanRepository extends JpaRepository<Peminjaman,Long> {
}
