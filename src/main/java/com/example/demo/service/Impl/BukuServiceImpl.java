package com.example.demo.service.Impl;

import com.example.demo.entity.Buku;
import com.example.demo.entity.Pengarang;
import com.example.demo.entity.dto.BukuDTO;
import com.example.demo.entity.mapping.BukuMapping;
import com.example.demo.entity.mapping.PengarangMapping;
import com.example.demo.repository.BukuRepository;
import com.example.demo.repository.PenerbitRepository;
import com.example.demo.repository.PengarangRepository;
import com.example.demo.service.BukuService;
import com.example.demo.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository repository;

    @Autowired
    PenerbitRepository penerbitRepository;

    @Autowired
    private PengarangRepository pengarangRepository;

    @Transactional
    @Override
    public BukuDTO save(BukuDTO param) {
        Pengarang pengarang = PengarangMapping.instance.toEntity(param.getPengarang());

        Buku data = BukuMapping.instance.toEntity(param);

        if (param.getPengarang() != null) {
            pengarang = pengarangRepository.save(pengarang);

            data.getPengarang().setId(pengarang.getId());
        }

        data = repository.save(data);

        return BukuMapping.instance.toDto(data);
    }


    @Transactional
    @Override
    public List<BukuDTO> findAllData() {

        return BukuMapping.instance.toListDto(repository.findAll());

    }

    @Transactional
    @Override
    public BukuDTO update(BukuDTO param, Long id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            data.setJudul(param.getJudul()== null ? data.getJudul() : param.getJudul());
            data.setTahunTerbit(param.getTahunTerbit()== null ? data.getTahunTerbit() : param.getTahunTerbit());
            data.setJumlah(param.getJumlah()== null ? data.getJumlah() : param.getJumlah());
            data.setIsbn(param.getIsbn()== null ? data.getIsbn() : param.getIsbn());



            return  BukuMapping.instance.toDto(repository.save(data));
        }
        return BukuMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public BukuDTO findById(Long id) {
        return BukuMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
