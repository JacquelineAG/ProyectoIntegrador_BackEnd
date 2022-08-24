package com.portfolio.argprog.Repository;

import com.portfolio.argprog.Entity.Idioma;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RIdioma extends JpaRepository<Idioma, Integer>{
    public Optional<Idioma> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}