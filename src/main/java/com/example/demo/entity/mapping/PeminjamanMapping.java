package com.example.demo.entity.mapping;

import com.example.demo.entity.Peminjaman;
import com.example.demo.entity.dto.PeminjamanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanMapping {
    PeminjamanMapping instance = Mappers.getMapper(PeminjamanMapping.class);

    Peminjaman toEntity(PeminjamanDTO dto);

    PeminjamanDTO toDto(Peminjaman param);

    List<PeminjamanDTO> toListDto(List<Peminjaman>peminjamanList);
}
