package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pengembalianDetail")
@Setter
@Getter
@NoArgsConstructor
public class PengembalianDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT(11)")
    private Long pengembalian_id;

    @ManyToOne
    @JoinColumn(name = "buku_id")
    private Buku buku;
}
