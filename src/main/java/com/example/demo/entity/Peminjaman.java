package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "peminjaman")
@Getter
@Setter
@NoArgsConstructor
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    private Date tglPinjam;

    private Date tglkembali;

    @OneToMany(mappedBy = "peminjaman_id")
    private List<PeminjamanDetail> peminjamanDetailList;

//    @OneToMany(mappedBy = "peminjaman")
//    private List<Pengembalian> pengembalianList;

    @ManyToOne
    @JoinColumn(name = "anggota_id")
    private Anggota anggota;

    @ManyToOne
    @JoinColumn(name = "petugas_id")
    private Petugas petugas;

    @ManyToMany
    @JoinTable(name = "peminjamanDetail")
    private List<Buku> buku;

    @JsonIgnore
    @OneToOne(mappedBy = "peminjaman")
    private Pengembalian pengembalian;

}
