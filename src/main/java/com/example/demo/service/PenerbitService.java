package com.example.demo.service;

import com.example.demo.entity.dto.PenerbitDTO;

import java.util.List;

public interface PenerbitService {
    PenerbitDTO save(PenerbitDTO param);

    List<PenerbitDTO> findAllData();

    PenerbitDTO update (PenerbitDTO param, Long id);

    Boolean delete(Long id);

    PenerbitDTO findById(Long id);
}
