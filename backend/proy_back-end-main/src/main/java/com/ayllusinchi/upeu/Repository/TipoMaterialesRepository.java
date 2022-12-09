package com.ayllusinchi.upeu.Repository;

import com.ayllusinchi.upeu.entidades.TipoMateriales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author etham
 */

@Repository
public interface TipoMaterialesRepository extends CrudRepository<TipoMateriales, Long>{
    
}
