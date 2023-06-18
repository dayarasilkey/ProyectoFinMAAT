package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.*;
import com.example.maatizzz.Repositorio.RepositorioProducto;
import com.example.maatizzz.Repositorio.RepositorioProveedor;
import com.example.maatizzz.Repositorio.RepositorioSuministro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioSuministro {
    private RepositorioSuministro repositoriosuministro;

    private RepositorioProducto ProducRepo;
    private RepositorioProveedor ProveRepo;

    public ServicioSuministro(RepositorioSuministro repositoriosuministro, RepositorioProducto producRepo, RepositorioProveedor proveRepo) {
        this.repositoriosuministro = repositoriosuministro;
        ProducRepo = producRepo;
        ProveRepo = proveRepo;
    }


    public ArrayList<Suministro> ListarSuministro() {
        return (ArrayList<Suministro>) repositoriosuministro.findAll();
    }

    public Suministro buscarSumistro(Integer idSuministro) {
        if (repositoriosuministro.findById(Integer.valueOf(String.valueOf(idSuministro))).isPresent())
            return repositoriosuministro.findById(idSuministro).get();
        else return null;
    }

    public ArrayList<Suministro> buscarDescripcionSumi(String descripcionSuministro) {
        return repositoriosuministro.findBydescripcionSuministro(descripcionSuministro);
    }

    public ArrayList<Suministro> buscarNombreSumi(String nombreSum) {
        return repositoriosuministro.findBynombreSum(nombreSum);
    }

    public String agregarSuministro(Integer id_producto, Integer id_proveedor, String descripcionSuministro, String nombreSum, Integer stockSum) {
        Optional<Productos> productosOptional = ProducRepo.findById(id_producto);
        Optional<Proveedor> proveedorOptional = ProveRepo.findById(id_proveedor);

        if (productosOptional.isPresent() && proveedorOptional.isPresent()){
            Productos productos = productosOptional.get();
            Proveedor proveedor = proveedorOptional.get();

            Suministro suministro = new Suministro(productos, proveedor, descripcionSuministro, nombreSum, stockSum);
            repositoriosuministro.save(suministro);
            return "Suministro Registrado exitosamente. ";
        }else {
            return "ERROR AL REGISTRAR SUMINISTRO. suministro no encontrado";
        }
    }


    public Suministro actualizarSuministro(Suministro suministro) {
        Optional<Suministro> suministroExistente = repositoriosuministro.findById(suministro.getIdSuministro());

        if (suministroExistente.isPresent()) {

            Suministro suministroActualizado = suministroExistente.get();
            suministroActualizado.setDescripcionSuministro(suministro.getDescripcionSuministro());
            suministroActualizado.setNombreSum(suministro.getNombreSum());
            suministroActualizado.setStockSum(suministro.getStockSum());
            // guardar la cotizacion actualizada en la base de datos
            return repositoriosuministro.save(suministroActualizado);
        } else {
            throw new RuntimeException("El suministro no existe.");
        }
    }

    public String eliminarSuministro(Integer idSuministro) {
        if (repositoriosuministro.existsById(Integer.valueOf(idSuministro))) {
            repositoriosuministro.deleteById(Integer.valueOf(idSuministro));
            return "Suministro eliminado exitosamente.";
        } else {
            return "El suministro no se encuentra registrado.";
        }
    }


    public List<Object[]>buscarStock(Integer dato){
        return repositoriosuministro.findBystocksum(dato);
    }
}
