package com.portfolio.argprog.Repository;

import com.portfolio.argprog.Entity.Cursos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCursos extends JpaRepository<Cursos, Integer>{
    public Optional<Cursos> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}