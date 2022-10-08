package com.example.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PengembalianDetailDTO {
    private Long pengembalian_id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BukuDTO buku;
}
