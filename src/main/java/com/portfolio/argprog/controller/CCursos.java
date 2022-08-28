package com.portfolio.argprog.Controller;

import com.portfolio.argprog.Dto.dtoCursos;
import com.portfolio.argprog.Entity.Cursos;
import com.portfolio.argprog.Service.SCursos;
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
@RequestMapping("/cursos")
@CrossOrigin(origins = "http://localhost:4200")
public class CCursos {
    @Autowired
    SCursos sCursos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list(){
        List<Cursos> list = sCursos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id")int id){
        if(!sCursos.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Cursos cursos = sCursos.getOne(id).get();
        return new ResponseEntity(cursos, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sCursos.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        sCursos.delete(id);
        return new ResponseEntity(new Mensaje("Curso eliminado correctamente."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCursos dtocursos){
        if(StringUtils.isBlank(dtocursos.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        Cursos cursos = new Cursos (
                dtocursos.getNombreE(), dtocursos.getDescripcionE(),dtocursos.getFechaE()
            );
        sCursos.save(cursos);
        return new ResponseEntity(new Mensaje("Curso creado correctamente."), HttpStatus.OK);
                
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoCursos dtocursos){
        if(!sCursos.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        if(StringUtils.isBlank(dtocursos.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio."), HttpStatus.BAD_REQUEST);
        }
        
        Cursos cursos = sCursos.getOne(id).get();
        
        cursos.setNombreE(dtocursos.getNombreE());
        cursos.setDescripcionE(dtocursos.getDescripcionE());
        cursos.setFechaE(dtocursos.getFechaE());
        
        sCursos.save(cursos);
        
        return new ResponseEntity(new Mensaje("Curso actualizado correctamente."), HttpStatus.OK);
    }
}