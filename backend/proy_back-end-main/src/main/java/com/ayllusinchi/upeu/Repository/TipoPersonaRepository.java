package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.TipoPersona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface TipoPersonaRepository extends CrudRepository<TipoPersona, Long>{
    
}
