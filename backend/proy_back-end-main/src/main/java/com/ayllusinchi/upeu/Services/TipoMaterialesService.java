package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.TipoMateriales;
import java.util.List;

/**
 *
 * @author etham
 */
public interface TipoMaterialesService {
    
    public List<TipoMateriales> findAll();
    public TipoMateriales findById(Long id);
    public TipoMateriales save (TipoMateriales tipoMateriales);
    public void delete(TipoMateriales tipoMateriales);
    public void deleteById(Long id);
    
}
