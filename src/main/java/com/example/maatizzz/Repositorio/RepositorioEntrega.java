package com.example.maatizzz.Repositorio;

import com.example.maatizzz.Entidad.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEntrega extends JpaRepository<Entrega, Integer>{

}
