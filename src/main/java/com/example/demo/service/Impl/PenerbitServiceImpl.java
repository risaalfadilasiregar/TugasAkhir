package com.example.demo.service.Impl;

import com.example.demo.entity.Penerbit;
import com.example.demo.entity.dto.PenerbitDTO;
import com.example.demo.entity.mapping.PenerbitMapping;
import com.example.demo.repository.PenerbitRepository;
import com.example.demo.service.PenerbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenerbitServiceImpl implements PenerbitService {

    @Autowired
    private PenerbitRepository repository;

    @Override
    public PenerbitDTO save(PenerbitDTO param) {
        Penerbit data = repository.save(PenerbitMapping.instance.toEntity(param));
        return PenerbitMapping.instance.toDto(data);
    }

    @Override
    public List<PenerbitDTO> findAllData() {
        return PenerbitMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public PenerbitDTO update(PenerbitDTO param, Long id) {
        Penerbit data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama(param.getNama() == null ? data.getNama() : param.getNama());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());

            return PenerbitMapping.instance.toDto(repository.save(data));
        }

        return PenerbitMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Penerbit data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PenerbitDTO findById(Long id) {
        return PenerbitMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
