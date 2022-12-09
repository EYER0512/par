package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.Programa;
import java.util.List;

/**
 *
 * @author etham
 */
public interface ProgramaService {
    
    public List<Programa> findAll();
    public Programa findById(Long id);
    public Programa save (Programa programa);
    public void delete(Programa programa);
    public void deleteById(Long id);
    
}
