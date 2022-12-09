package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.ProgramaRepository;
import com.ayllusinchi.upeu.Services.ProgramaService;
import com.ayllusinchi.upeu.entidades.Programa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class ProgramaServiceImpl implements ProgramaService{

    @Autowired
    ProgramaRepository programaRepository;
    
    @Override
    public List<Programa> findAll() {
        return (List<Programa>) programaRepository.findAll();
    }

    @Override
    public Programa findById(Long id) {
        return programaRepository.findById(id).orElse(null);
    }

    @Override
    public Programa save(Programa programa) {
        return programaRepository.save(programa);
    }

    @Override
    public void delete(Programa programa) {
        programaRepository.delete(programa);
    }

    @Override
    public void deleteById(Long id) {
        programaRepository.deleteById(id);
    }
    
}
