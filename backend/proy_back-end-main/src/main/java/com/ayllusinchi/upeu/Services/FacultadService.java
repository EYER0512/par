package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.Facultad;
import java.util.List;

/**
 *
 * @author etham
 */
public interface FacultadService {
    
    public List<Facultad> findAll();
    public Facultad findById(Long id);
    public Facultad save (Facultad facultad);
    public void delete(Facultad facultad);
    public void deleteById(Long id);
    
}
