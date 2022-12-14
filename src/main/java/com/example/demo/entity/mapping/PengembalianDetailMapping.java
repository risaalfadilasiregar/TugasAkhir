package com.example.demo.entity.mapping;

import com.example.demo.entity.PengembalianDetail;
import com.example.demo.entity.dto.PengembalianDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianDetailMapping {
    PengembalianDetailMapping instance = Mappers.getMapper(PengembalianDetailMapping.class);

    PengembalianDetail toEntity(PengembalianDetailDTO dto);

    PengembalianDetailDTO toDto(PengembalianDetail param);

    List<PengembalianDetailDTO> toListDto   (List<PengembalianDetail> pengembalianDetailList);
}
