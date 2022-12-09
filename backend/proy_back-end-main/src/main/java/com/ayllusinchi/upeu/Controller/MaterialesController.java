package com.ayllusinchi.upeu.Controller;

import com.ayllusinchi.upeu.Services.MaterialesService;
import com.ayllusinchi.upeu.entidades.Materiales;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
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
 * @author etham
 */

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/materiales")
@Api(value = "Microservicio de Gestion de los materiales", description = "Microservicio de Gestion de los materiales")
public class MaterialesController {
    
    @Autowired
    MaterialesService materialesService;
    
    @ApiOperation(value = "Lista de materiales")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de facultades");
        result.put("data", materialesService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene datos de materiales")
    @GetMapping("/{id}")
    public ResponseEntity<Materiales> findById(@PathVariable Long id) {
        Materiales materiales = materialesService.findById(id);
        return ResponseEntity.ok(materiales);
    }

    
    @ApiOperation(value = "Crea un material")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Materiales materiales) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Material registrado correctamente");
        result.put("data", materialesService.save(materiales));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    @ApiOperation(value = "Modifica un material")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Materiales materiales) {
        HashMap<String, Object> result = new HashMap<>();
        Materiales data = materialesService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            materiales.setMaId(id);
            materialesService.save(materiales);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", materiales);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Elimina una facultad")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
    Materiales data = materialesService.findById(id);
    if(data == null){
        result.put("success", false);
        result.put("message", "No existe material con id:" + id);
  return new ResponseEntity <>(result, HttpStatus.NOT_FOUND);
    } else{
  materialesService.deleteById(id);
            result.put("success", true);
            result.put("message", "Registro Eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    
}