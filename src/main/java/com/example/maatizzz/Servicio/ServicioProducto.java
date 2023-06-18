package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.Categoria;
import com.example.maatizzz.Entidad.Productos;
import com.example.maatizzz.Repositorio.RepositorioCategoria;
import com.example.maatizzz.Repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioProducto {
    private RepositorioProducto repositorioproducto;
    private RepositorioCategoria CategoRepo;

    public ServicioProducto(RepositorioProducto repositorioproducto, RepositorioCategoria categoRepo) {
        this.repositorioproducto = repositorioproducto;
        CategoRepo = categoRepo;
    }

    public ArrayList<Productos> ListarProductos() {
        return (ArrayList<Productos>) repositorioproducto.findAll();
    }

    public Productos buscaridpro(Integer id_producto) {
        if (repositorioproducto.findById(id_producto).isPresent())
            return repositorioproducto.findById(id_producto).get();
        else return null;
    }


    public ArrayList<Productos> buscarNombrepro(String nombreProd) {
        return repositorioproducto.findByNombreProd(nombreProd);
    }
    public ArrayList<Productos> buscarDescripcionpro(String descripcion) {
        return repositorioproducto.findByDescripcion(descripcion);
    }


    public String agregarProducto(Integer id_categoria, String nombreProd, Float precioProducto, int stock, String descripcion) {
        Optional<Categoria> categoriaOptional = CategoRepo.findById(id_categoria);

        if (categoriaOptional.isPresent()){
            Categoria categoria = categoriaOptional.get();

            Productos productos = new Productos(categoria, nombreProd, precioProducto, stock, descripcion);
            repositorioproducto.save(productos);
            return "Producto Registrado exitosamente. ";
        }else {
            return "ERROR AL REGISTRAR PRODUCTO. producto no encontrado";
        }
    }

    public Productos actualizarProducto(Productos productos) {

        Optional<Productos> productoExistente = repositorioproducto.findById(productos.getId_producto());
        if (productoExistente.isPresent()){

            Productos productosActualizado = productoExistente.get();
            productosActualizado.setNombreProd(productos.getNombreProd());
            productosActualizado.setPrecioProducto(productos.getPrecioProducto());
            productosActualizado.setStock(productos.getStock());
            productosActualizado.setDescripcion(productos.getDescripcion());

            return repositorioproducto.save(productosActualizado);
        }else {
            throw new RuntimeException("El Producto no existe");
        }
    }

    public String eliminarProducto(Integer id_categoria) {
        if (repositorioproducto.existsById(Integer.valueOf(id_categoria))){
            repositorioproducto.deleteById(Integer.valueOf(id_categoria));
            return "Producto eliminado";
        } else {
            return "El Producto no se encuentra registrado";
        }
    }

}
