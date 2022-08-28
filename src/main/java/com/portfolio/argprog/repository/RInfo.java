package com.portfolio.argprog.Repository;

import com.portfolio.argprog.Entity.Info;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RInfo extends JpaRepository<Info, Integer>{
    public Optional<Info> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}