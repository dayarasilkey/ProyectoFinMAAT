package com.example.maatizzz.Servicio;
import com.example.maatizzz.Entidad.Rol;
import com.example.maatizzz.Repositorio.RepositorioRol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioRol {
    private RepositorioRol repositoriorol;

    public ServicioRol(RepositorioRol repositorio) {
        this.repositoriorol = repositorio;
    }

    public ArrayList<Rol> ListarRol() {
        return (ArrayList<Rol>) repositoriorol.findAll();
    }

    public Rol buscarRol(Integer id_rol) {
        if (repositoriorol.findById(id_rol).isPresent())
            return repositoriorol.findById(id_rol).get();
        else return null;
    }

    public ArrayList<Rol> buscarNombre(String nombre) {
        return repositoriorol.findByNombre(nombre);
    }

    public ArrayList<Rol> buscarDescripcion(String descripcion) {
        return repositoriorol.findByDescripcion(descripcion);
    }

    public ArrayList<Rol> buscarEstado(String estado) {
        return repositoriorol.findByEstado(estado);
    }

    public String agregarRol(Rol rol) {

        if (repositoriorol.findById(rol.getId_rol()).isPresent())
            return "El Rol ya se encuentra registrado";
        else
            repositoriorol.save(rol);
        return "El Rol se registro exitosamente.";

    }

    public String actualizarRol(Rol rol) {

        if (repositoriorol.findById(rol.getId_rol()).isPresent()){
            repositoriorol.save(rol);
            return "El Rol se actualizo exitosamente.";
        }
        else{
            return "El Rol no se encuentra registrado";

        }
    }

    public String eliminarRol(Integer id_rol) {
        if (repositoriorol.findById(id_rol).isPresent()) {
            repositoriorol.deleteById(id_rol);
            return "Rol eliminado";
        } else {
            return "El Rol no se encuentra registrado";
        }
    }
}
