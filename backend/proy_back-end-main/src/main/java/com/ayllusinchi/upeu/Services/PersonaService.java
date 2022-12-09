package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.Persona;
import java.util.List;

/**
 *
 * @author etham
 */
public interface PersonaService {
    
    public List<Persona> findAll();
    public Persona findById(Long id);
    public Persona save (Persona persona);
    public void delete(Persona persona);
    public void deleteById(Long id);
    
}
