package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.Proveedor;
import com.example.maatizzz.Repositorio.RepositorioProveedor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioProveedor {
    private RepositorioProveedor repositorioproveedor;

    public ServicioProveedor(RepositorioProveedor repositorio) {
        this.repositorioproveedor = repositorio;
    }

    public ArrayList<Proveedor> ListarProveedor() {
        return (ArrayList<Proveedor>) repositorioproveedor.findAll();
    }

    public Proveedor buscarProv(Integer id_proveedor) {
        if (repositorioproveedor.findById(id_proveedor).isPresent())
            return repositorioproveedor.findById(id_proveedor).get();
        else return null;
    }

    public ArrayList<Proveedor> buscarnombrepro(String nombreProvedor) {
        return repositorioproveedor.findByNombreProvedor(nombreProvedor);
    }

    public ArrayList<Proveedor> buscartelefonopro(String telefono) {
        return repositorioproveedor.findByTelefono(telefono);
    }

    public ArrayList<Proveedor> buscaremailpro(String email) {
        return repositorioproveedor.findByEmail(email);
    }

    public String agregarProv(Proveedor proveedor) {

        if (repositorioproveedor.findById(proveedor.getId_proveedor()).isPresent())
            return "El Provedor ya se encuentra registrado";
        else
            repositorioproveedor.save(proveedor);
        return "El Provedor se registro exitosamente.";

    }

    public String actualizarProv(Proveedor proveedor) {

        if (repositorioproveedor.findById(proveedor.getId_proveedor()).isPresent()){
            repositorioproveedor.save(proveedor);
            return "El Provedor se actualizo exitosamente.";
        }
        else{
            return "El Provedor no se encuentra registrado";

        }
    }

    public String eliminarProve(Integer id_proveedor) {
        if (repositorioproveedor.findById(id_proveedor).isPresent()) {
            repositorioproveedor.deleteById(id_proveedor);
            return "Proveedor eliminado";
        } else {
            return "El Proveedor no se encuentra registrado";
        }
    }
}
