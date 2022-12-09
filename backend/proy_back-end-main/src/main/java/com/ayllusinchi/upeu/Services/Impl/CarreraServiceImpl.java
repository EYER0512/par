package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.CarreraRepository;
import com.ayllusinchi.upeu.Services.CarreraService;
import com.ayllusinchi.upeu.entidades.Carrera;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class CarreraServiceImpl implements CarreraService{

    @Autowired
    CarreraRepository carreraRepository;
    
    @Override
    public List<Carrera> findAll() {
        return (List<Carrera>) carreraRepository.findAll();
    }

    @Override
    public Carrera findById(Long id) {
        return carreraRepository.findById(id).orElse(null);
    }

    @Override
    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    public void delete(Carrera carrera) {
        carreraRepository.delete(carrera);
    }

    @Override
    public void deleteById(Long id) {
        carreraRepository.deleteById(id);
    }
    
}
