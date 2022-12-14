/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayllusinchi.upeu.Services.Impl;

import com.ayllusinchi.upeu.Repository.AsistenciaRepository;
import com.ayllusinchi.upeu.Services.AsistenciasService;
import com.ayllusinchi.upeu.entidades.Asistencias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yrenz
 */
@Service
public class AsistenciaServiceImpl implements AsistenciasService{
    
    @Autowired
    AsistenciaRepository asistenciaRepository;

    @Override
    public List<Asistencias> findAll() {
        return (List<Asistencias>) asistenciaRepository.findAll();
    }

    @Override
    public Asistencias findById(Long id) {
        return asistenciaRepository.findById(id).orElse(null);
    }

    @Override
    public Asistencias save(Asistencias asistencias) {
        return asistenciaRepository.save(asistencias);
    }

    @Override
    public void delete(Asistencias asistencias) {
        asistenciaRepository.delete(asistencias);
    }

    @Override
    public void deleteById(Long id) {
        asistenciaRepository.deleteById(id);
    }
    
}
