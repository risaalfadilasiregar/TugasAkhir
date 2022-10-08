package com.example.demo.service.Impl;

import com.example.demo.entity.Petugas;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.PetugasDTO;
import com.example.demo.entity.mapping.PetugasMapping;
import com.example.demo.entity.mapping.UserMapping;
import com.example.demo.repository.PetugasRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PetugasServiceImpl implements PetugasService {

    @Autowired
    private PetugasRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public PetugasDTO save(PetugasDTO param) {
        User user = UserMapping.instance.toEntity(param.getUser());

        Petugas data = PetugasMapping.instance.toEntity(param);

        if (param.getUser().getId_user() == null) {
            return null;
        }
        if (param.getUser() != null) {
            user = userRepository.save(user);

            data.getUser().setId_user(user.getId_user());
        }

        data = repository.save(data);

        return PetugasMapping.instance.toDto(data);
    }

    @Transactional
    @Override
    public List<PetugasDTO> findAllData() {

        return PetugasMapping.instance.toListDto(repository.findAll());
    }

    @Transactional
    @Override
    public PetugasDTO update(PetugasDTO param, Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNama(param.getNama() == null ? data.getNama() : param.getNama());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());


            return  PetugasMapping.instance.toDto(repository.save(data));
        }
        return PetugasMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PetugasDTO findById(Long id) {

        return PetugasMapping.instance.toDto(repository.findById(id).orElse(null));

    }
}
