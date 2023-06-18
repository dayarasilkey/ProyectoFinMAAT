package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.*;
import com.example.maatizzz.Repositorio.RepositorioEntrega;
import com.example.maatizzz.Repositorio.RepositorioPedido;
import com.example.maatizzz.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


@Service
public class ServicioEntrega {

    private RepositorioEntrega repositorioEntrega;
    private RepositorioUsuario UsuRepo;
    private RepositorioPedido PedRepo;

    public ServicioEntrega(RepositorioEntrega repositorioEntrega, RepositorioUsuario usuRepo, RepositorioPedido pedRepo) {
        this.repositorioEntrega = repositorioEntrega;
        UsuRepo = usuRepo;
        PedRepo = pedRepo;
    }

    public ArrayList<Entrega> ListarEntrega() {
        return (ArrayList<Entrega>) repositorioEntrega.findAll();
    }

    public Entrega buscarEnt(Integer id_entrega) {
        if (repositorioEntrega.findById(id_entrega).isPresent())
            return repositorioEntrega.findById(id_entrega).get();
        else return null;
    }

    //public ArrayList<Entrega> buscarFechae(Date fechae) {
    //    return repositorio.findByFechae(fechae);
    //}

    public String agregarEnt(Entrega entrega) {

        if (repositorioEntrega.findById(entrega.getId_entrega()).isPresent())
            return "La entrega ya se encuentra registrado";
        else
            repositorioEntrega.save(entrega);
        return "La etrega se registro exitosamente.";

    }

    public String actualizarEnt(Entrega entrega) {

        if (repositorioEntrega.findById(entrega.getId_entrega()).isPresent()){
            repositorioEntrega.save(entrega);
            return "La Entrega se actualizo exitosamente.";
        }
        else{
            return "La entrega no se encuentra registrado";

        }
    }

    public String eliminarEnt(Integer id_entrega) {
        if (repositorioEntrega.findById(id_entrega).isPresent()) {
            repositorioEntrega.deleteById(id_entrega);
            return "Entrega eliminada";
        } else {
            return "La Entrega no se encuentra registrada";
        }
    }

    public String agregarEntrega(Integer id_usuario, Integer id_pedido, Date fechae, int numPedido) {
        Optional<Usuario> usuarioOptional = UsuRepo.findById(id_usuario);
        Optional<Pedido> pedidoOptional = PedRepo.findById(id_pedido);

        if (usuarioOptional.isPresent() && pedidoOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            Pedido pedido = pedidoOptional.get();

            Entrega entrega = new Entrega(usuario, pedido, fechae, numPedido);
            repositorioEntrega.save(entrega);
            return "Entrega Registrada exitosamente. ";
        }else {
            return "ERROR AL REGISTRAR ENTREGA. entrega no encontrado";
        }
    }


    public Entrega actualizarEntrega(Entrega entrega) {
        Optional<Entrega> entregaExistente = repositorioEntrega.findById(entrega.getId_entrega());

        if (entregaExistente.isPresent()) {

            Entrega entregaActualizada = entregaExistente.get();
            entregaActualizada.setFechae(entrega.getFechae());
            entregaActualizada.setNumPedido(entrega.getNumPedido());
            return repositorioEntrega.save(entregaActualizada);
        } else {
            throw new RuntimeException("La Entrega no existe.");
        }
    }

    public String eliminarEntrega(Integer id_entrega) {
        if (repositorioEntrega.existsById(Integer.valueOf(id_entrega))) {
            repositorioEntrega.deleteById(Integer.valueOf(id_entrega));
            return "Entrega eliminada exitosamente.";
        } else {
            return "La entrega no se encuentra registrado.";
        }
    }

}
