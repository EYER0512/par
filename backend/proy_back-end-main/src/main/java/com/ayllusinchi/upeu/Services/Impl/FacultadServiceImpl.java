package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.FacultadRepository;
import com.ayllusinchi.upeu.Services.FacultadService;
import com.ayllusinchi.upeu.entidades.Facultad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class FacultadServiceImpl implements FacultadService{

    @Autowired
    FacultadRepository facultadRepository;
    
    @Override
    public List<Facultad> findAll() {
        return (List<Facultad>) facultadRepository.findAll();
    }

    @Override
    public Facultad findById(Long id) {
        return facultadRepository.findById(id).orElse(null);
    }

    @Override
    public Facultad save(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    @Override
    public void delete(Facultad facultad) {
        facultadRepository.delete(facultad);
    }

    @Override
    public void deleteById(Long id) {
        facultadRepository.deleteById(id);
    }
    
}
