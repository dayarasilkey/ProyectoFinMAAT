package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.*;
import com.example.maatizzz.Repositorio.RepositorioPedido;
import com.example.maatizzz.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class ServicioPedido {

    private RepositorioPedido repositoriopedido;
    private RepositorioUsuario UsuRepo;

    public ServicioPedido(RepositorioPedido repositoriopedido, RepositorioUsuario usuRepo) {
        this.repositoriopedido = repositoriopedido;
        UsuRepo = usuRepo;
    }

    public ArrayList<Pedido> ListarPedido() {
        return (ArrayList<Pedido>) repositoriopedido.findAll();
    }

    public Pedido buscarPed(Integer id_pedido) {
        if (repositoriopedido.findById(id_pedido).isPresent())
            return repositoriopedido.findById(id_pedido).get();
        else return null;
    }

    //public ArrayList<Pedido> buscarFecha(String fecha) {
      //  return repositorio.findByFecha(fecha);
    //}

    public ArrayList<Pedido> buscarEstadop(String estadop) {
        return repositoriopedido.findByEstadop(estadop);
    }


    public String agregarPedido(Integer id_usuario, Date fecha, int impuesto, int totalped, String estadop) {
        Optional<Usuario> usuarioOptional = UsuRepo.findById(id_usuario);


        if (usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();

            Pedido pedido = new Pedido(usuario, fecha, impuesto, totalped, estadop);
            repositoriopedido.save(pedido);
            return "Pedido Registrado exitosamente. ";
        }else {
            return "ERROR AL REGISTRAR PEDIDO. pedido no encontrado";
        }
    }


    public Pedido actualizarPedido(Pedido pedido) {
        Optional<Pedido> pedidoExistente = repositoriopedido.findById(pedido.getId_pedido());

        if (pedidoExistente.isPresent()) {

            Pedido pedidoActualizado = pedidoExistente.get();
            pedidoActualizado.setFecha(pedido.getFecha());
            pedidoActualizado.setImpuesto(pedido.getImpuesto());
            pedidoActualizado.setTotalped(pedido.getTotalped());
            pedidoActualizado.setEstadop(pedido.getEstadop());
            return repositoriopedido.save(pedidoActualizado);
        } else {
            throw new RuntimeException("El Pedido no existe.");
        }
    }

    public String eliminarPedido(Integer id_pedido) {
        if (repositoriopedido.existsById(Integer.valueOf(id_pedido))) {
            repositoriopedido.deleteById(Integer.valueOf(id_pedido));
            return "Pedido eliminado exitosamente.";
        } else {
            return "El Pedido no se encuentra registrado.";
        }
    }

    //public List<Object[]> Buscarpedidousu(String usu){
    //    return  repositorio.findPedidousuario(usu);
    //}

    //public List<Object[]> Buscarpedidoent(String ent){
     //   return  repositorio.findPedidoEntrga(ent);
    //}

}
