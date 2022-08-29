package com.portfolio.argprog.Controller;

import com.portfolio.argprog.Dto.dtoInfo;
import com.portfolio.argprog.Entity.Info;
import com.portfolio.argprog.Service.SInfo;
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
@RequestMapping("/acercade")
@CrossOrigin(origins = "https://argprogfrontend.web.app")
public class CInfo {
    @Autowired
    SInfo sInfo;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Info>> list(){
        List<Info> list = sInfo.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Info> getById(@PathVariable("id")int id){
        if(!sInfo.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.BAD_REQUEST);
        }
        
        Info info = sInfo.getOne(id).get();
        return new ResponseEntity(info, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sInfo.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }
        sInfo.delete(id);
        return new ResponseEntity(new Mensaje("Información eliminada correctamente."), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoInfo dtoinfo){
        if(StringUtils.isBlank(dtoinfo.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Info info = new Info (
                dtoinfo.getNombreE(), dtoinfo.getDescripcionE()
            );
        sInfo.save(info);
        return new ResponseEntity(new Mensaje("Información creada correctamente."), HttpStatus.OK);
                
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoInfo dtoinfo){
        if(!sInfo.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe."), HttpStatus.NOT_FOUND);
        }

        if(StringUtils.isBlank(dtoinfo.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio."), HttpStatus.BAD_REQUEST);
        }
        
        Info info = sInfo.getOne(id).get();
        
        info.setNombreE(dtoinfo.getNombreE());
        info.setDescripcionE(dtoinfo.getDescripcionE());
        
        sInfo.save(info);
        
        return new ResponseEntity(new Mensaje("Información actualizada correctamente."), HttpStatus.OK);
    }
}