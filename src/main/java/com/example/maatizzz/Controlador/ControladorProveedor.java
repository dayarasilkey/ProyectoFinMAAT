package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Proveedor;
import com.example.maatizzz.Servicio.ServicioProveedor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorProveedor {
    private ServicioProveedor servicio;

    public ControladorProveedor(ServicioProveedor servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarProveedor")
    public ArrayList<Proveedor> ListarProveedor(){
        return servicio.ListarProveedor();
    }

    @GetMapping ("/buscarProv/{id_proveedor}")
    Proveedor buscarProv(@PathVariable("id_proveedor")Integer id_proveedor){
        return  servicio.buscarProv(id_proveedor);
    }

    @GetMapping ("/buscarnombreprov/{nombreProvedor}")
    public ArrayList<Proveedor> buscarnombrepro(@PathVariable("nombreProvedor")String nombreProvedor){
        return servicio.buscarnombrepro(nombreProvedor);
    }

    @GetMapping ("/buscartelefonoprov/{telefono}")
    public ArrayList<Proveedor> buscartelefonopro(@PathVariable("telefono")String telefono){
        return servicio.buscartelefonopro(telefono);
    }

    @GetMapping ("/buscaremailprov/{email}")
    public ArrayList<Proveedor> buscaremailpro(@PathVariable("email")String email){
        return servicio.buscaremailpro(email);
    }

    @PostMapping("/agregarProv")
    public  String agregarProv(@RequestBody Proveedor proveedor){
        return servicio.agregarProv(proveedor);
    }

    @PutMapping("/actualizarProv")
    public  String actualizarProv(@RequestBody Proveedor proveedor){
        return servicio.actualizarProv(proveedor);
    }

    @DeleteMapping("/eliminarProve/{id_proveedor}")
    public String eliminarProve(@PathVariable("id_proveedor") Integer id_proveedor){
        return servicio.eliminarProve(id_proveedor);
    }
}
