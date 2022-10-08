package com.example.demo.entity.mapping;

import com.example.demo.entity.PeminjamanDetail;
import com.example.demo.entity.dto.PeminjamanDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanDetailMapping {
    PeminjamanDetailMapping instance = Mappers.getMapper(PeminjamanDetailMapping.class);

    PeminjamanDetail toEntity(PeminjamanDetailDTO dto);

    PeminjamanDetailDTO toDto(PeminjamanDetail param);

    List<PeminjamanDetailDTO> toListDto   (List<PeminjamanDetail> peminjamanDetailList);
}
