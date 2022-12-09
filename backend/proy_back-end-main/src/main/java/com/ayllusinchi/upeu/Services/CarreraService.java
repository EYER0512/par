package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.Carrera;
import java.util.List;

/**
 *
 * @author etham
 */
public interface CarreraService {
    
    public List<Carrera> findAll();
    public Carrera findById(Long id);
    public Carrera save (Carrera carrera);
    public void delete(Carrera carrera);
    public void deleteById(Long id);
    
}
