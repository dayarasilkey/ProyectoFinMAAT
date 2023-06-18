package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.Categoria;
import com.example.maatizzz.Repositorio.RepositorioCategoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioCategoria {
    private RepositorioCategoria repositoriocategoria;

    public ServicioCategoria(RepositorioCategoria repositorio) {
        this.repositoriocategoria = repositorio;
    }

    public ArrayList<Categoria> ListarCategoria() {
        return (ArrayList<Categoria>) repositoriocategoria.findAll();
    }

    public Categoria buscaridcat(Integer id_categoria) {
        if (repositoriocategoria.findById(id_categoria).isPresent())
            return repositoriocategoria.findById(id_categoria).get();
        else return null;
    }

    public ArrayList<Categoria> buscarombreCat(String nombreCat) {
        return repositoriocategoria.findByNombreCat(nombreCat);
    }

    public ArrayList<Categoria> buscarTipoCat(String tipoCat) {
        return repositoriocategoria.findByTipoCat(tipoCat);
    }

    public ArrayList<Categoria> buscarDescripcionCat(String descripcionCat) {
        return repositoriocategoria.findByDescripcionCat(descripcionCat);
    }

    public String agregarCategoria(Categoria categoria) {

        if (repositoriocategoria.findById(categoria.getId_categoria()).isPresent())
            return "La Categoria ya se encuentra registrado";
        else
            repositoriocategoria.save(categoria);
        return "La Categoria se registro exitosamente.";

    }

    public String actualizarCategoria(Categoria categoria) {

        if (repositoriocategoria.findById(categoria.getId_categoria()).isPresent()){
            repositoriocategoria.save(categoria);
            return "La Categoria se actualizo exitosamente.";
        }
        else{
            return "La Categoria no se encuentra registrado";

        }
    }

    public String eliminarCategoria(Integer id_categoria) {
        if (repositoriocategoria.findById(id_categoria).isPresent()) {
            repositoriocategoria.deleteById(id_categoria);
            return "La categoria ha sido eliminado";
        } else {
            return "El categoria no se encuentra registrado";
        }
    }
}
