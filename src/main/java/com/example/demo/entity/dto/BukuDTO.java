package com.example.demo.entity.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BukuDTO {
    private Long id;

    private String judul;

    private String tahunTerbit;

    private Integer jumlah;

    private String isbn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PengarangDTO pengarang;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PenerbitDTO penerbit;
}

