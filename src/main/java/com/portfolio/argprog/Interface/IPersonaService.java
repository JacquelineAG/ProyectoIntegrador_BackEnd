package com.portfolio.argprog.Interface;

import com.portfolio.argprog.entity.Persona;
import java.util.List;

public interface IPersonaService {
    // Lista de Personas
    public List<Persona> getPersona(); 
    
    // Guardar obj Persona
    public void savePersona(Persona persona);
    
    // Eliminar obj por Id
    public void deletePersona(Long id);
    
    // Buscar Persona por Id
    public Persona findPersona(Long id);
    
    
}
