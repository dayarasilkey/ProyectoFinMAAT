package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Pedido;
import com.example.maatizzz.Servicio.ServicioPedido;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class ControladorPedido {

    private ServicioPedido serviciopedido;

    public ControladorPedido(ServicioPedido serviciopedido) {
        this.serviciopedido = serviciopedido;
    }

    @GetMapping("/listarPedido")
    public ArrayList<Pedido> ListarPedido(){
        return serviciopedido.ListarPedido();
    }
    @GetMapping ("/buscarPed/{id_pedido}")
    Pedido buscarRol(@PathVariable("id_pedido")Integer id_pedido){
        return  serviciopedido.buscarPed(id_pedido);
    }

    //@GetMapping ("/buscarFecha/{fecha}")
    //public ArrayList<Pedido> buscarFecha(@PathVariable("fecha")String f){
    //    return servicio.buscarFecha(f);
    //}

    @GetMapping ("/buscarEstadop/{estadop}")
    public ArrayList<Pedido> buscarEstadop(@PathVariable("estadop")String e){
        return serviciopedido.buscarEstadop(e);
    }

    @PostMapping("/agregarPedido/{id_usuario}")
    public String agregarPedido(@PathVariable("id_usuario") Integer id_usuario,
                                @RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
                                 @RequestParam("impuesto") int impuesto,
                                 @RequestParam("totalped") int totalped,
                                 @RequestParam("estadop") String estadop){

        return serviciopedido.agregarPedido(id_usuario, fecha, impuesto, totalped, estadop);
    }

    @PutMapping("/actualizarPedido/{id_pedido}")
    public ResponseEntity<Pedido> actualizarUsuario(@PathVariable Integer id_pedido, @RequestBody Pedido pedido) {
        pedido.getId_pedido();
        Pedido pedidoActualizado = serviciopedido.actualizarPedido(pedido);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("/eliminarPedido/{id_pedido}")
    public String eliminarPedido(@PathVariable("id_pedido") Integer id_pedido){
        return serviciopedido.eliminarPedido(id_pedido);
    }


    //Metodo buscar pedido por usuario
    //@GetMapping("/PedidosUsuario/{usu}")
  //  public List<Map<String, Object>> Buscarpedidousu(@PathVariable("usu")String usu) {
  //    List<Object[]> lista = serviciopedido.Buscarpedidousu(usu);
  //    List<Map<String, Object>> json = new ArrayList<>();

  //    for (Object[] objects : lista) {
  //        Map<String, Object> datos = new LinkedHashMap<>();
  //        datos.put("id_pedido", objects[0]);
  //        datos.put("fecha", objects[1]);
  //        datos.put("impuesto", objects[2]);
  //        datos.put("totalped", objects[3]);
  //        datos.put("estadop", objects[4]);
  //        datos.put("id_usuario", objects[5]);
  //        datos.put("nombre", objects[6]);
  //        datos.put("apellido", objects[7]);
  //        datos.put("numdocumento", objects[8]);
  //        datos.put("direccion", objects[9]);
  //        datos.put("telefono", objects[10]);
  //        datos.put("email", objects[11]);
  //        datos.put("contraseña", objects[12]);
  //        json.add(datos);
  //    }

  //    for (Map<String, Object> j : json) {
  //        System.out.println(j);
  //    }

  //    return json;
  //}


  ////Metodo buscar pedido por entrega
  //@GetMapping("/PedidosEntrega/{ent}")
  //public List<Map<String, Object>> Buscarpedidoent(@PathVariable("ent")String ent) {
  //    List<Object[]> lista = serviciopedido.Buscarpedidoent(ent);
  //    List<Map<String, Object>> json = new ArrayList<>();

  //    for (Object[] objects : lista) {
  //        Map<String, Object> datos = new LinkedHashMap<>();
  //        datos.put("id_pedido", objects[0]);
  //        datos.put("fecha", objects[1]);
  //        datos.put("impuesto", objects[2]);
  //        datos.put("totalped", objects[3]);
  //        datos.put("estadop", objects[4]);
  //        datos.put("id_entrega", objects[5]);
  //        datos.put("fechae", objects[6]);
  //        datos.put("numPedido", objects[7]);
  //        json.add(datos);
  //    }

  //    for (Map<String, Object> j : json) {
  //        System.out.println(j);
  //    }

  //    return json;
  //}


}
