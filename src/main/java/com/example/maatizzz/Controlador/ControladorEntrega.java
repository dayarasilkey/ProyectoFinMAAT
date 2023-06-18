package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Entrega;
import com.example.maatizzz.Entidad.Suministro;
import com.example.maatizzz.Servicio.ServicioEntrega;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class ControladorEntrega {
    private ServicioEntrega servicio;

    public ControladorEntrega(ServicioEntrega servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarEntrega")
    public ArrayList<Entrega> ListarEntrega(){
        return servicio.ListarEntrega();
    }

    @GetMapping ("/buscarEnt/{id_entrega}")
    Entrega buscarEnt(@PathVariable("id_entrega")Integer id_entrega){
        return  servicio.buscarEnt(id_entrega);
    }


    @PostMapping("/agregarEntrega/{id_usuario}/{id_pedido}")
    public String agregarEntrega(@PathVariable("id_usuario") Integer id_usuario,
                                 @PathVariable("id_pedido") Integer id_pedido,
                                 @RequestParam("fechae") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechae,
                                 @RequestParam("numPedido") int numPedido) {
        return servicio.agregarEntrega(id_usuario, id_pedido, fechae, numPedido);
    }


    @PutMapping("/actualizarEntrega/{id_entrega}")
    public ResponseEntity<Entrega> actualizarEntrega(@PathVariable Integer id_entrega, @RequestBody Entrega entrega) {
        entrega.setId_entrega(id_entrega);
        Entrega entregaActualizada = servicio.actualizarEntrega(entrega);
        return ResponseEntity.ok(entregaActualizada);
    }

    @DeleteMapping("/eliminarEntrega/{id_entrega}")
    public String eliminarEntrega(@PathVariable("id_entrega") Integer id_entrega) {
        return servicio.eliminarEntrega(id_entrega);
    }
}
