package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.MaterialesRepository;
import com.ayllusinchi.upeu.Services.MaterialesService;
import com.ayllusinchi.upeu.entidades.Materiales;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class MaterialesServiceImpl implements MaterialesService{
    
    @Autowired
    MaterialesRepository materialesRepository;

    @Override
    public List<Materiales> findAll() {
        return (List<Materiales>) materialesRepository.findAll();
    }

    @Override
    public Materiales findById(Long id) {
        return materialesRepository.findById(id).orElse(null);
    }

    @Override
    public Materiales save(Materiales materiales) {
        return materialesRepository.save(materiales);
    }

    @Override
    public void delete(Materiales materiales) {
        materialesRepository.delete(materiales);
    }

    @Override
    public void deleteById(Long id) {
        materialesRepository.deleteById(id);
    }
    
}
