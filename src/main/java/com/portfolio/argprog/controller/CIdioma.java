package com.portfolio.argprog.Controller;

import com.portfolio.argprog.Dto.dtoIdioma;
import com.portfolio.argprog.Entity.Idioma;
import com.portfolio.argprog.Service.SIdioma;
import com.portfolio.argprog.security.controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idioma")
@CrossOrigin(origins = "http://localhost:4200")
public class CIdioma {
    @Autowired
    SIdioma sIdioma;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Idioma>> list(){
        List<Idioma> list = sIdioma.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Idioma> getById(@PathVariable("id")int id){
        if(!sIdioma.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Idioma idioma = sIdioma.getOne(id).get();
        return new ResponseEntity(idioma, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sIdioma.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        sIdioma.delete(id);
        return new ResponseEntity(new Mensaje("Idioma eliminado correctamente."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoIdioma dtoidioma){
        if(StringUtils.isBlank(dtoidioma.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Idioma idioma = new Idioma (
                dtoidioma.getNombreE(), dtoidioma.getDescripcionE()
            );
        sIdioma.save(idioma);
        return new ResponseEntity(new Mensaje("Idioma creado correctamente."), HttpStatus.OK);
                
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoIdioma dtoidioma){
        if(!sIdioma.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        if(StringUtils.isBlank(dtoidioma.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio."), HttpStatus.BAD_REQUEST);
        }
        
        Idioma idioma = sIdioma.getOne(id).get();
        
        idioma.setNombreE(dtoidioma.getNombreE());
        idioma.setDescripcionE(dtoidioma.getDescripcionE());
        
        sIdioma.save(idioma);
        
        return new ResponseEntity(new Mensaje("Idioma actualizado correctamente."), HttpStatus.OK);
    }
}