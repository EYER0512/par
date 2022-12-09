package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.PersonaRepository;
import com.ayllusinchi.upeu.Services.PersonaService;
import com.ayllusinchi.upeu.entidades.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;
    
    @Override
    public List<Persona> findAll() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(Persona persona) {
        personaRepository.delete(persona);
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
    
}
