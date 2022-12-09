package com.ayllusinchi.upeu.Controller;

import com.ayllusinchi.upeu.Services.PersonaTallerService;
import com.ayllusinchi.upeu.entidades.PersonaTaller;
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
 *
 */

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/personataller")
@Api(value = "Microservicio de Gestion de las personas en los talleres", description = "Microservicio de Gestion de las personas en los talleres")
public class PersonaTallerController {
    
    @Autowired
    PersonaTallerService personaTallerService;

    @ApiOperation(value = "Lista de personaTaller")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de personaTaller");
        result.put("data", personaTallerService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene datos de una personaTaller")
    @GetMapping("/{id}")
    public ResponseEntity<PersonaTaller> findById(@PathVariable Long id) {
        PersonaTaller personaTaller = personaTallerService.findById(id);
        return ResponseEntity.ok(personaTaller);
    }

    
    @ApiOperation(value = "Crea una personaTaller")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonaTaller personaTaller) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "PersonaTaller registrado correctamente");
        result.put("data", personaTallerService.save(personaTaller));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //a

    
    @ApiOperation(value = "Modifica una personaTaller")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody PersonaTaller personaTaller) {
        HashMap<String, Object> result = new HashMap<>();
        PersonaTaller data = personaTallerService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            personaTaller.setPeId(id);
            personaTallerService.save(personaTaller);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", personaTaller);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Elimina una personaTaller")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
    PersonaTaller data = personaTallerService.findById(id);
    if(data == null){
        result.put("success", false);
        result.put("message", "No existe personaTaller con id:" + id);
  return new ResponseEntity <>(result, HttpStatus.NOT_FOUND);
    } else{
  personaTallerService.deleteById(id);
            result.put("success", true);
            result.put("message", "Registro Eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    
}