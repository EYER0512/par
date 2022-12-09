package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.Facultad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface FacultadRepository extends CrudRepository<Facultad, Long>{
    
}
