package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.TipoPersonaRepository;
import com.ayllusinchi.upeu.Services.TipoPersonaService;
import com.ayllusinchi.upeu.entidades.TipoPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class TipoPersonaServiceImpl implements TipoPersonaService{

    @Autowired
    TipoPersonaRepository tipoPersonaRepository;
    
    @Override
    public List<TipoPersona> findAll() {
        return (List<TipoPersona>) tipoPersonaRepository.findAll();
    }

    @Override
    public TipoPersona findById(Long id) {
        return tipoPersonaRepository.findById(id).orElse(null);
    }

    @Override
    public TipoPersona save(TipoPersona tipoPersona) {
        return tipoPersonaRepository.save(tipoPersona);
    }

    @Override
    public void delete(TipoPersona tipoPersona) {
        tipoPersonaRepository.delete(tipoPersona);
    }

    @Override
    public void deleteById(Long id) {
        tipoPersonaRepository.deleteById(id);
    }
    
}
