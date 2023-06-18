package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.DetallePedido;
import com.example.maatizzz.Servicio.ServicioDetallePedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorDetallePedido {
    private ServicioDetallePedido servicio;

    public ControladorDetallePedido(ServicioDetallePedido servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarDetallePed")
    public ArrayList<DetallePedido> ListarDetallePed(){
        return servicio.ListarDetallePed();
    }

    @GetMapping ("/buscarDetallePed/{idDetallePedido}")
    DetallePedido buscarDetallePed(@PathVariable("idDetallePedido")Integer idDetallePedido){
        return  servicio.buscarDetallePed(idDetallePedido);
    }

    @PostMapping("/agregarDetallePed/{id_pedido}/{id_producto}")
    public String agregarDetallePed(@PathVariable("id_pedido") Integer id_pedido,
                                    @PathVariable("id_producto") Integer id_producto,
                                 @RequestParam("cantidad") int cantidad,
                                 @RequestParam("precioCantidad") int precioCantidad,
                                 @RequestParam("descuento") int descuento,
                                 @RequestParam("numPedido") int numPedido){

        return servicio.agregarDetallePed(id_pedido,id_producto, cantidad, precioCantidad, descuento, numPedido);
    }

    @PutMapping("/actualizarDetallePed/{idDetallePedido}")
    public ResponseEntity<DetallePedido> actualizarDetallePed(@PathVariable Integer idDetallePedido, @RequestBody DetallePedido detallePedido) {
        detallePedido.setIdDetallePedido(idDetallePedido);
        DetallePedido detallePedidoActualizado = servicio.actualizarDetallePed(detallePedido);
        return ResponseEntity.ok(detallePedidoActualizado);
    }

    @DeleteMapping("/eliminarDetallePed/{idDetallePedido}")
    public String eliminarDetallePed(@PathVariable("idDetallePedido") Integer idDetallePedido){
        return servicio.eliminarDetallePed(idDetallePedido);
    }
}
