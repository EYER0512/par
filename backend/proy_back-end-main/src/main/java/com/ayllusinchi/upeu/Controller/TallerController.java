package com.ayllusinchi.upeu.Controller;

import com.ayllusinchi.upeu.Services.TallerService;
import com.ayllusinchi.upeu.entidades.Taller;
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
@RequestMapping("/talleres")
@Api(value = "Microservicio de Gestion de los talleres", description = "Microservicio de Gestion de los talleres")
public class TallerController {
    
   @Autowired
   TallerService tallerService;
    
     @ApiOperation(value = "Lista de Talleres")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de Talleres");
        result.put("data", tallerService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
   @ApiOperation(value = "Obtiene datos de un taller")
    @GetMapping("/{id}")
    public ResponseEntity<Taller> findById(@PathVariable Long id) {
        Taller taller = tallerService.findById(id);
        return ResponseEntity.ok(taller);
    }
    
    @ApiOperation(value = "Crea un taller")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Taller taller) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Taller registrado correctamente");
        result.put("data", tallerService.save(taller));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Modifica un taller")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Taller taller) {
        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallerService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            taller.setTaId(id);
            tallerService.save(taller);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", taller);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Elimina un taller")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
    Taller data = tallerService.findById(id);
    if(data == null){
        result.put("success", false);
        result.put("message", "No existe taller con id:" + id);
  return new ResponseEntity <>(result, HttpStatus.NOT_FOUND);
    } else{
  tallerService.deleteById(id);
            result.put("success", true);
            result.put("message", "Registro Eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    
}