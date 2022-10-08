package com.example.demo.service.Impl;

import com.example.demo.entity.Pengarang;
import com.example.demo.entity.dto.PengarangDTO;
import com.example.demo.entity.mapping.PengarangMapping;
import com.example.demo.repository.PengarangRepository;
import com.example.demo.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PengarangServiceImpl implements PengarangService {

    @Autowired
    private PengarangRepository repository;

    @Transactional
    @Override
    public PengarangDTO save(PengarangDTO param) {
        Pengarang data = repository.save(PengarangMapping.instance.toEntity(param));
        return PengarangMapping.instance.toDto(data);
    }

    @Override
    public List<PengarangDTO> findAllData() {

        return PengarangMapping.instance.toListDto(repository.findAll());
    }

    @Transactional
    @Override
    public PengarangDTO update(PengarangDTO param, Long id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama(param.getNama() == null ? data.getNama() : param.getNama());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());

            return PengarangMapping.instance.toDto(repository.save(data));
        }

        return PengarangMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PengarangDTO findById(Long id) {
        return PengarangMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
