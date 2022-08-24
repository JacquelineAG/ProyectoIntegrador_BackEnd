package com.portfolio.argprog.Service;

import com.portfolio.argprog.Entity.Idioma;
import com.portfolio.argprog.Repository.RIdioma;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SIdioma {
    @Autowired
    RIdioma rIdioma;
    
    public List<Idioma> list(){
        return rIdioma.findAll();
    }
    
    public Optional<Idioma> getOne(int id){
        return rIdioma.findById(id);
    }
    
    public Optional<Idioma> getByNmbreE(String nombreE){
        return rIdioma.findByNombreE(nombreE);
    }
    
    public void save(Idioma idioma){
        rIdioma.save(idioma);
    }
    
    public void delete(int id){
        rIdioma.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rIdioma.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rIdioma.existsByNombreE(nombreE);
    }
}