/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayllusinchi.upeu.Controller;

import com.ayllusinchi.upeu.Services.AsistenciasService;
import com.ayllusinchi.upeu.entidades.Asistencias;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yrenz
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/Asistencias")
@Api(value = "Microservicio de Gestion de las Asistencias", description = "Microservicio de Gestion de las Asistencias")
public class AsistenciasController {
    
    @Autowired
    AsistenciasService asistenciasService;
    
    @ApiOperation(value = "Lista de Asistencias")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de carreras");
        result.put("data", asistenciasService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene datos de Asistencias")
    @GetMapping("/{id}")
    public ResponseEntity<Asistencias> findById(@PathVariable Long id) {
        Asistencias asistencias = asistenciasService.findById(id);
        return ResponseEntity.ok(asistencias);
    }

    
    @ApiOperation(value = "Crea una Asistencias")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Asistencias asistencias) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Carrera registrado correctamente");
        result.put("data", asistenciasService.save(asistencias));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    @ApiOperation(value = "Modifica una Asistencias")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Asistencias asistencias) {
        HashMap<String, Object> result = new HashMap<>();
        Asistencias data = asistenciasService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            asistencias.setCaId(id);
            asistenciasService.save(asistencias);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", asistencias);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Elimina una carrera")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
    Asistencias data = asistenciasService.findById(id);
    if(data == null){
        result.put("success", false);
        result.put("message", "No existe carrera con id:" + id);
  return new ResponseEntity <>(result, HttpStatus.NOT_FOUND);
    } else{
  asistenciasService.deleteById(id);
            result.put("success", true);
            result.put("message", "Registro Eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    
    
    
}
