package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.Programa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface ProgramaRepository extends CrudRepository<Programa, Long>{
    
}
