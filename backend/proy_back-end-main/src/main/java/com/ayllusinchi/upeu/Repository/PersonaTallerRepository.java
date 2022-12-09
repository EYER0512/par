package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.PersonaTaller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface PersonaTallerRepository extends CrudRepository<PersonaTaller, Long>{
    
}
