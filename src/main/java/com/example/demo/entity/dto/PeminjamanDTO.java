package com.example.demo.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter

public class PeminjamanDTO {
    private Long id;

    private Date tglPinjam;

    private Date tglkembali;

    private AnggotaDTO anggota;

    private PetugasDTO petugas;
}
