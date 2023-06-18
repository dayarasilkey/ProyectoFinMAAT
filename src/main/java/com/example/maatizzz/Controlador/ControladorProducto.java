package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Productos;
import com.example.maatizzz.Entidad.Usuario;
import com.example.maatizzz.Servicio.ServicioProducto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class ControladorProducto {
    private ServicioProducto servicio;

    public ControladorProducto(ServicioProducto servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarProductos")
    public ArrayList<Productos> ListarProductos(){
        return servicio.ListarProductos();
    }

    @GetMapping ("/buscaridpro/{id_producto}")
    Productos buscaridpro(@PathVariable("id_producto")Integer id_producto){
        return  servicio.buscaridpro(id_producto);
    }

    @GetMapping ("/buscarNombrepro/{nombreProd}")
    public ArrayList<Productos> buscarNombrepro(@PathVariable("nombreProd")String n){
        return servicio.buscarNombrepro(n);
    }

    @GetMapping ("/buscarDescripcionpro/{descripcion}")
    public ArrayList<Productos> buscarDescripcionpro(@PathVariable("descripcion")String d){
        return servicio.buscarDescripcionpro(d);
    }

    @PostMapping("/agregarProducto/{id_categoria}")
    public  String agregarProducto(@PathVariable("id_categoria") Integer id_categoria,
                                   @RequestParam("nombreProd") String nombreProd,
                                   @RequestParam("precioProducto") Float precioProducto,
                                   @RequestParam("stock") int stock,
                                   @RequestParam("descripcion") String descripcion){
        return servicio.agregarProducto(id_categoria, nombreProd, precioProducto, stock, descripcion);
    }

    @PutMapping("/actualizarProducto/{id_producto}")
    public ResponseEntity<Productos> actualizarProductos(@PathVariable Integer id_producto, @RequestBody Productos productos) {
        productos.setId_producto(id_producto);
        Productos productosActualizado = servicio.actualizarProducto(productos);
        return ResponseEntity.ok(productosActualizado);
    }

    @DeleteMapping("/eliminarProducto/{Id_producto}")
    public String eliminarProducto(@PathVariable("Id_producto") Integer Id_producto){
        return servicio.eliminarProducto(Id_producto);
    }
}
