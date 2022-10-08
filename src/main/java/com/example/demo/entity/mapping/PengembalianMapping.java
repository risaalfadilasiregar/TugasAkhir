package com.example.demo.entity.mapping;

import com.example.demo.entity.Pengembalian;
import com.example.demo.entity.dto.PengembalianDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianMapping {
    PengembalianMapping instance = Mappers.getMapper(PengembalianMapping.class);

    Pengembalian toEntity(PengembalianDTO dto);

    PengembalianDTO toDto(Pengembalian param);

    List<PengembalianDTO> toListDto(List<Pengembalian>pengembalianList);
}
