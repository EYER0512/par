package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.TipoPersona;
import java.util.List;

/**
 *
 * @author etham
 */
public interface TipoPersonaService {

    public List<TipoPersona> findAll();
    public TipoPersona findById(Long id);
    public TipoPersona save (TipoPersona tipoPersona);
    public void delete(TipoPersona tipoPersona);
    public void deleteById(Long id);
    
}
