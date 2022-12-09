package com.ayllusinchi.upeu.Controller;

import com.ayllusinchi.upeu.Services.TipoMaterialesService;
import com.ayllusinchi.upeu.entidades.TipoMateriales;
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
@RequestMapping("/tipomateriales")
@Api(value = "Microservicio de Gestion del tipo de materiales", description = "Microservicio de Gestion del tipo de materiales")
public class TipoMaterialesController {
    
    @Autowired
    TipoMaterialesService tipoMaterialesService;

    @ApiOperation(value = "Lista de tipoMateriales")
    @GetMapping
    public ResponseEntity<?> findAll() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Lista de tipoMateriales");
        result.put("data", tipoMaterialesService.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(value = "Obtiene datos de un tipoMateriales")
    @GetMapping("/{id}")
    public ResponseEntity<TipoMateriales> findById(@PathVariable Long id) {
        TipoMateriales tipoMateriales = tipoMaterialesService.findById(id);
        return ResponseEntity.ok(tipoMateriales);
    }

    
    @ApiOperation(value = "Crea un tipoMateriales")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody TipoMateriales tipoMateriales) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "tipoMateriales registrado correctamente");
        result.put("data", tipoMaterialesService.save(tipoMateriales));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    //a

    
    @ApiOperation(value = "Modifica un tipoMateriales")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @RequestBody TipoMateriales tipoMateriales) {
        HashMap<String, Object> result = new HashMap<>();
        TipoMateriales data = tipoMaterialesService.findById(id);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con Id: " + id);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            tipoMateriales.setTmId(id);
            tipoMaterialesService.save(tipoMateriales);
            result.put("success", true);
            result.put("message", "Datos actualizados correctamente.");
            result.put("data", tipoMateriales);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @ApiOperation(value = "Elimina un tipoMateriales")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        HashMap<String, Object> result = new HashMap<>();
    TipoMateriales data = tipoMaterialesService.findById(id);
    if(data == null){
        result.put("success", false);
        result.put("message", "No existe tipoMateriales con id:" + id);
  return new ResponseEntity <>(result, HttpStatus.NOT_FOUND);
    } else{
  tipoMaterialesService.deleteById(id);
            result.put("success", true);
            result.put("message", "Registro Eliminado correctamente");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
    
}