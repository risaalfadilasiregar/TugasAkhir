package com.example.demo.service;

import com.example.demo.entity.dto.PengembalianDetailDTO;

import java.util.List;

public interface PengembalianDetailService {

    PengembalianDetailDTO save(PengembalianDetailDTO param);

    List<PengembalianDetailDTO> findAllData();

    PengembalianDetailDTO update(PengembalianDetailDTO param, Long id);

    Boolean delete(Long id);

    PengembalianDetailDTO findById(Long id);
}
