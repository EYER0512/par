package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.PersonaTaller;
import java.util.List;

/**
 *
 * @author etham
 */
public interface PersonaTallerService {
    
    public List<PersonaTaller> findAll();
    public PersonaTaller findById(Long id);
    public PersonaTaller save (PersonaTaller personaTaller);
    public void delete(PersonaTaller personaTaller);
    public void deleteById(Long id);
    
}
