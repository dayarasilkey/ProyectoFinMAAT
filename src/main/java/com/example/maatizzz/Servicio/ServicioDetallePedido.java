package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.*;
import com.example.maatizzz.Repositorio.RepositorioDetallePedido;
import com.example.maatizzz.Repositorio.RepositorioPedido;
import com.example.maatizzz.Repositorio.RepositorioProducto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioDetallePedido {
    private RepositorioDetallePedido repositorioDetallePedido;
    private RepositorioPedido PedRepo;
    private RepositorioProducto ProdRepo;

    public ServicioDetallePedido(RepositorioDetallePedido repositorioDetallePedido, RepositorioPedido pedRepo, RepositorioProducto prodRepo) {
        this.repositorioDetallePedido = repositorioDetallePedido;
        PedRepo = pedRepo;
        ProdRepo = prodRepo;
    }

    public ArrayList<DetallePedido> ListarDetallePed() {
        return (ArrayList<DetallePedido>) repositorioDetallePedido.findAll();
    }

    public DetallePedido buscarDetallePed(Integer idDetallePedido) {
        if (repositorioDetallePedido.findById(idDetallePedido).isPresent())
            return repositorioDetallePedido.findById(idDetallePedido).get();
        else return null;
    }

    public String agregarDetallePed(Integer id_pedido, Integer id_producto, int cantidad, int precioCantidad, int descuento, int numPedido) {
        Optional<Pedido> pedidoOptional = PedRepo.findById(id_pedido);
        Optional<Productos> productosOptional = ProdRepo.findById(id_producto);

        if (pedidoOptional.isPresent() && productosOptional.isPresent()){
            Pedido pedido = pedidoOptional.get();
            Productos productos = productosOptional.get();

            DetallePedido detallePedido = new DetallePedido(pedido, productos, cantidad, precioCantidad, descuento, numPedido);
            repositorioDetallePedido.save(detallePedido);
            return "Detalle Pedido Registrado exitosamente. ";
        }else {
            return "ERROR AL REGISTRAR DETALLE PEDIDO. Detalle Pedido no encontrado";
        }
    }


    public DetallePedido actualizarDetallePed(DetallePedido detallePedido) {
        Optional<DetallePedido> detallePedidoExistente = repositorioDetallePedido.findById(detallePedido.getIdDetallePedido());

        if (detallePedidoExistente.isPresent()) {

            DetallePedido detallePedidoActualizado = detallePedidoExistente.get();
            detallePedidoActualizado.setCantidad(detallePedido.getCantidad());
            detallePedidoActualizado.setPrecioCantidad(detallePedido.getPrecioCantidad());
            detallePedidoActualizado.setDescuento(detallePedido.getDescuento());
            detallePedidoActualizado.setNumPedido(detallePedido.getNumPedido());
            return repositorioDetallePedido.save(detallePedidoActualizado);
        } else {
            throw new RuntimeException("El Detalle Pedido no existe.");
        }
    }

    public String eliminarDetallePed(Integer idDetallePedido) {
        if (repositorioDetallePedido.existsById(Integer.valueOf(idDetallePedido))) {
            repositorioDetallePedido.deleteById(Integer.valueOf(idDetallePedido));
            return "Detalle Pedido eliminado exitosamente.";
        } else {
            return "El Detalle Pedido no se encuentra registrado.";
        }
    }
}
