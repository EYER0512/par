package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.Taller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface TallerRepository extends CrudRepository<Taller, Long>{
    
}
