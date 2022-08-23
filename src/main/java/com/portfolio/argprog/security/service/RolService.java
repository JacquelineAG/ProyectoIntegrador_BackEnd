package com.portfolio.argprog.security.service;

import com.portfolio.argprog.security.entity.Rol;
import com.portfolio.argprog.security.enums.RolNombre;
import com.portfolio.argprog.security.repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
    return irolRepository.findByRolNombre(rolNombre);
}
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}