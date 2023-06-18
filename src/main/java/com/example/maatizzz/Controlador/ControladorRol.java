package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Rol;
import com.example.maatizzz.Servicio.ServicioRol;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorRol {
    private ServicioRol servicio;

    public ControladorRol(ServicioRol servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarRol")
    public ArrayList<Rol> ListarRol(){
        return servicio.ListarRol();
    }

    @GetMapping ("/buscarRol/{id_rol}")
    Rol buscarRol(@PathVariable("id_rol")Integer id_rol){
        return  servicio.buscarRol(id_rol);
    }

    @GetMapping ("/buscarNombre/{nombre}")
    public ArrayList<Rol> buscarNombre(@PathVariable("nombre")String n){
        return servicio.buscarNombre(n);
    }

    @GetMapping ("/buscarDescripcion/{descripcion}")
    public ArrayList<Rol> buscarApellido(@PathVariable("descripcion")String d){
        return servicio.buscarDescripcion(d);
    }

    @GetMapping ("/buscarEstado/{estado}")
    public ArrayList<Rol> buscarEstado(@PathVariable("estado")String e){
        return servicio.buscarEstado(e);
    }
    @PostMapping("/agregarRol")
    public  String agregarRol(@RequestBody Rol rol){
        return servicio.agregarRol(rol);
    }

    @PutMapping("/actualizarRol")
    public  String actualizarRol(@RequestBody Rol rol){
        return servicio.actualizarRol(rol);
    }

    @DeleteMapping("/eliminarRol/{id_rol}")
    public String eliminarRol(@PathVariable("id_rol") Integer id_rol){
        return servicio.eliminarRol(id_rol);
    }




}
