package com.example.demo.service.Impl;

import com.example.demo.entity.Anggota;
import com.example.demo.entity.Peminjaman;
import com.example.demo.entity.dto.PeminjamanDTO;
import com.example.demo.entity.mapping.AnggotaMapping;
import com.example.demo.entity.mapping.PeminjamanMapping;
import com.example.demo.repository.AnggotaRepository;
import com.example.demo.repository.PeminjamanRepository;
import com.example.demo.repository.PetugasRepository;
import com.example.demo.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepository repository;

    @Autowired
    AnggotaRepository anggotaRepository;

    @Autowired
    private PetugasRepository petugasRepository;

    @Transactional
    @Override
    public PeminjamanDTO save(PeminjamanDTO param) {
        Anggota anggota = AnggotaMapping.instance.toEntity(param.getAnggota());

        Peminjaman data = PeminjamanMapping.instance.toEntity(param);

        if (param.getAnggota() != null) {
            anggota = anggotaRepository.save(anggota);

            data.getAnggota().setId(anggota.getId());
        }

        data = repository.save(data);

        return PeminjamanMapping.instance.toDto(data);
    }

    @Transactional
    @Override
    public List<PeminjamanDTO> findAllData() {
        return PeminjamanMapping.instance.toListDto(repository.findAll());
    }

    @Transactional
    @Override
    public PeminjamanDTO update(PeminjamanDTO param, Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            data.setTglPinjam(param.getTglPinjam()== null ? data.getTglPinjam() : param.getTglPinjam());
            data.setTglkembali(param.getTglkembali() != null ? param.getTglkembali() : data.getTglkembali());

            return  PeminjamanMapping.instance.toDto(repository.save(data));
        }
        return PeminjamanMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PeminjamanDTO findById(Long id) {
        return PeminjamanMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
