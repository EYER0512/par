package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.Materiales;
import java.util.List;

/**
 *
 * @author etham
 */
public interface MaterialesService {
    
    public List<Materiales> findAll();
    public Materiales findById(Long id);
    public Materiales save (Materiales materiales);
    public void delete(Materiales materiales);
    public void deleteById(Long id);
    
}
