package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.TallerRepository;
import com.ayllusinchi.upeu.Services.TallerService;
import com.ayllusinchi.upeu.entidades.Taller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class TallerServiceImpl implements TallerService{

    @Autowired
    TallerRepository tallerRepository;
    
    @Override
    public List<Taller> findAll() {
        return (List<Taller>) tallerRepository.findAll();
    }

    @Override
    public Taller findById(Long id) {
        return tallerRepository.findById(id).orElse(null);
    }

    @Override
    public Taller save(Taller taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public void delete(Taller taller) {
        tallerRepository.delete(taller);
    }

    @Override
    public void deleteById(Long id) {
        tallerRepository.deleteById(id);
    }
    
}