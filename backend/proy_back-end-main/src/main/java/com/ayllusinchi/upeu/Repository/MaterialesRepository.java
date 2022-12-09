package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.Materiales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface MaterialesRepository extends CrudRepository<Materiales, Long>{
    
}
