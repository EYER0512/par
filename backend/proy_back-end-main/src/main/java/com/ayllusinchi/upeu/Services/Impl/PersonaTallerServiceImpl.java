package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.PersonaTallerRepository;
import com.ayllusinchi.upeu.Services.PersonaTallerService;
import com.ayllusinchi.upeu.entidades.PersonaTaller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class PersonaTallerServiceImpl implements PersonaTallerService{
    
    @Autowired
    PersonaTallerRepository personaTallerRepository;

    @Override
    public List<PersonaTaller> findAll() {
        return (List<PersonaTaller>) personaTallerRepository.findAll();
    }

    @Override
    public PersonaTaller findById(Long id) {
        return personaTallerRepository.findById(id).orElse(null);
    }

    @Override
    public PersonaTaller save(PersonaTaller personaTaller) {
        return personaTallerRepository.save(personaTaller);
    }

    @Override
    public void delete(PersonaTaller personaTaller) {
        personaTallerRepository.delete(personaTaller);
    }

    @Override
    public void deleteById(Long id) {
        personaTallerRepository.deleteById(id);
    }
    
}
