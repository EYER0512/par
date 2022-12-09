package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.Taller;
import java.util.List;

/**
 *
 * @author etham
 */
public interface TallerService {
    
    public List<Taller> findAll();
    public Taller findById(Long id);
    public Taller save (Taller taller);
    public void delete(Taller taller);
    public void deleteById(Long id);
    
}
