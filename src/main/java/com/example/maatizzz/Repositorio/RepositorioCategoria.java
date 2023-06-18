package com.example.maatizzz.Repositorio;

import com.example.maatizzz.Entidad.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Integer> {
    ArrayList<Categoria> findByNombreCat(String nombreCat);
    ArrayList<Categoria> findByTipoCat(String tipoCat);
    ArrayList<Categoria> findByDescripcionCat(String descripcionCat);
}
