package com.ayllusinchi.upeu.Controller;

import com.ayllusinchi.upeu.Services.ProgramaService;
import com.ayllusinchi.upeu.entidades.Programa;
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
 * @author etham
 */
//Agregado en clase de angular
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/programas")
@Api(value = "Microservicio de Gestion de los programas", description = "Microservicio de Gestion de los programas")
public class ProgramaController {
    
    @Autowired
    ProgramaService programaService;
    
    @ApiOperation(value = "Lista de programas")
    @GetMapping()
    public ResponseEntity<?> findAll(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de Personas");
        result.put("data", programaService.findAll());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    
    @ApiOperation(value = "Obtiene datos de un programa")
    @GetMapping("/{id}")
    public ResponseEntity<Programa> findById(@PathVariable Long id){
        Programa programa = programaService.findById(id);
        return ResponseEntity.ok(programa);
    }
    
   @ApiOperation(value = "Crea una programa")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Programa programa) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Programa registrado correctamente");
        result.put("data", programaService.save(programa));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
    @ApiOperation(value = "Modifica una programa")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody Programa programa) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            programa.setProId(id);
            programaService.save(programa);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", programa);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
   @ApiOperation(value = "Elimina una programa")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = programaService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            programaService.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
