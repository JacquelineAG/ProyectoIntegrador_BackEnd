package com.portfolio.argprog.Service;

import com.portfolio.argprog.Entity.Cursos;
import com.portfolio.argprog.Repository.RCursos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCursos {
    @Autowired
    RCursos rCursos;
    
    public List<Cursos> list(){
        return rCursos.findAll();
    }
    
    public Optional<Cursos> getOne(int id){
        return rCursos.findById(id);
    }
    
    public Optional<Cursos> getByNmbreE(String nombreE){
        return rCursos.findByNombreE(nombreE);
    }
    
    public void save(Cursos idioma){
        rCursos.save(idioma);
    }
    
    public void delete(int id){
        rCursos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rCursos.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rCursos.existsByNombreE(nombreE);
    }
}