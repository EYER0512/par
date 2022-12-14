/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ayllusinchi.upeu.Services;

import com.ayllusinchi.upeu.entidades.Asistencias;
import java.util.List;

/**
 *
 * @author yrenz
 */
public interface AsistenciasService {
    
     public List<Asistencias> findAll();
    public Asistencias findById(Long id);
    public Asistencias save (Asistencias asistencias);
    public void delete(Asistencias asistencias);
    public void deleteById(Long id);
    
}
