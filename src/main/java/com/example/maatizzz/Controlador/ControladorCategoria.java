package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Categoria;
import com.example.maatizzz.Servicio.ServicioCategoria;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorCategoria {
    private ServicioCategoria servicio;
    public ControladorCategoria(ServicioCategoria servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarCategoria")
    public ArrayList<Categoria> ListarCategoria() {
        return servicio.ListarCategoria();
    }

    @GetMapping("/buscaridcat/{id_categoria}")
    Categoria buscaridcat(@PathVariable("id_categoria") Integer id_categoria) {
        return servicio.buscaridcat(id_categoria);
    }

    @GetMapping("/buscarombreCat/{nombreCat}")
    public ArrayList<Categoria> buscarombreCat(@PathVariable("nombreCat") String n) {
        return servicio.buscarombreCat(n);
    }

    @GetMapping("/buscarTipoCat/{nombreCat}")
    public ArrayList<Categoria> buscarTipoCat(@PathVariable("fecha") String t) {
        return servicio.buscarTipoCat(t);
    }

    @GetMapping("/buscarDescripcionCat/{tipoCat}")
    public ArrayList<Categoria> buscarDescripcionCat(@PathVariable("tipoCat") String t) {
        return servicio.buscarDescripcionCat(t);
    }

    @PostMapping("/agregarCategoria")
    public String agregarCategoria(@RequestBody Categoria categoria) {
        return servicio.agregarCategoria(categoria);
    }

    @PutMapping("/actualizarCategoria")
    public String actualizarCategoria(@RequestBody Categoria categoria) {
        return servicio.actualizarCategoria(categoria);
    }

    @DeleteMapping("/eliminarCategoria/{id_categoria}")
    public String eliminarCategoria(@PathVariable("id_categoria") Integer id_categoria) {
        return servicio.eliminarCategoria(id_categoria);
    }
}
