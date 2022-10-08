package com.example.demo.service;

import com.example.demo.entity.dto.AnggotaDTO;
import com.example.demo.entity.Anggota;

import java.util.List;

public interface AnggotaService {
    AnggotaDTO save(AnggotaDTO param);

    List<AnggotaDTO> findAllData();

    AnggotaDTO update (AnggotaDTO param, Long id);

    Boolean delete(Long id);

    AnggotaDTO findById(Long id);
}
