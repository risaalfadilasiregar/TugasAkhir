package com.example.demo.service;

import com.example.demo.entity.dto.PetugasDTO;

import java.util.List;

public interface PetugasService {
    PetugasDTO save(PetugasDTO param);

    List<PetugasDTO> findAllData();

    PetugasDTO update (PetugasDTO param, Long id);

    Boolean delete(Long id);

    PetugasDTO findById(Long id);
}
