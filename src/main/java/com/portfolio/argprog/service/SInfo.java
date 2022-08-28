package com.portfolio.argprog.Service;

import com.portfolio.argprog.Entity.Info;
import com.portfolio.argprog.Repository.RInfo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SInfo{
    @Autowired
    RInfo rInfo;
    
    public List<Info> list(){
        return rInfo.findAll();
    }
    
    public Optional<Info> getOne(int id){
        return rInfo.findById(id);
    }
    
    public Optional<Info> getByNmbreE(String nombreE){
        return rInfo.findByNombreE(nombreE);
    }
    
    public void save(Info info){
        rInfo.save(info);
    }
    
    public void delete(int id){
        rInfo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rInfo.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rInfo.existsByNombreE(nombreE);
    }
}