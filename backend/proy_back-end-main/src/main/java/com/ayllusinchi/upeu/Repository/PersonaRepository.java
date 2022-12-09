package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    
}
