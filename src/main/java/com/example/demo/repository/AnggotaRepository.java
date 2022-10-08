package com.example.demo.repository;

import com.example.demo.entity.Anggota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnggotaRepository extends JpaRepository<Anggota, Long> {

}
