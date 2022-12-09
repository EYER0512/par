package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.TipoMaterialesRepository;
import com.ayllusinchi.upeu.Services.TipoMaterialesService;
import com.ayllusinchi.upeu.entidades.TipoMateriales;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author etham
 */

@Service
public class TipoMaterialesServiceImpl implements TipoMaterialesService{

    @Autowired
    TipoMaterialesRepository tipoMaterialesRepository;
    
    @Override
    public List<TipoMateriales> findAll() {
        return (List<TipoMateriales>) tipoMaterialesRepository.findAll();
    }

    @Override
    public TipoMateriales findById(Long id) {
        return tipoMaterialesRepository.findById(id).orElse(null);
    }

    @Override
    public TipoMateriales save(TipoMateriales tipoMateriales) {
        return tipoMaterialesRepository.save(tipoMateriales);
    }

    @Override
    public void delete(TipoMateriales tipoMateriales) {
        tipoMaterialesRepository.delete(tipoMateriales);
    }

    @Override
    public void deleteById(Long id) {
        tipoMaterialesRepository.deleteById(id);
    }
    
}
