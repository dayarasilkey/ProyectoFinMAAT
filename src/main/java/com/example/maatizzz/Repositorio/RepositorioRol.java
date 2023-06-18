package com.example.maatizzz.Repositorio;

import com.example.maatizzz.Entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Integer> {

    ArrayList<Rol> findByNombre(String nombre);
    ArrayList<Rol> findByDescripcion(String descripcion);
    ArrayList<Rol> findByEstado (String estado);

}
