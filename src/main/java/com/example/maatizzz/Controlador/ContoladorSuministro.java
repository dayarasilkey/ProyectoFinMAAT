package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Suministro;
import com.example.maatizzz.Servicio.ServicioSuministro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ContoladorSuministro {
    private ServicioSuministro servicio;

    public ContoladorSuministro(ServicioSuministro servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarSuministro")
    public ArrayList<Suministro> ListarSuministro(){
        return servicio.ListarSuministro();
    }

    @GetMapping ("/buscarSumistro/{idSuministro}")
    Suministro buscarSumistro(@PathVariable("idSuministro")Integer idSuministro){
        return  servicio.buscarSumistro(idSuministro);
    }

    @GetMapping ("/buscardescripcionSuministro/{descripcionSuministro}")
    public ArrayList<Suministro> buscardescripcionSuministro(@PathVariable("descripcionDetallePro")String d){
        return servicio.buscarDescripcionSumi(d);
    }


    @GetMapping ("/buscarNombreSumi/{nombreSum}")
    public ArrayList<Suministro> buscarNombreSumi(@PathVariable("nombreSum")String n){
        return servicio.buscarNombreSumi(n);
    }

    @PostMapping("/agregarSuministro/{id_producto}/{id_proveedor}")
    public String agregarSuministro(@PathVariable("id_producto") Integer id_producto,
                                    @PathVariable("id_proveedor") Integer id_proveedor,
                                    @RequestParam("descripcionSuministro") String descripcionSuministro,
                                    @RequestParam("nombreSum") String nombreSum,
                                    @RequestParam("stockSum") Integer stockSum) {
        return servicio.agregarSuministro(id_producto, id_proveedor, descripcionSuministro, nombreSum, stockSum);
    }


    @PutMapping("/actualizarSuministro/{idSuministro}")
    public ResponseEntity<Suministro> actualizarSuministro(@PathVariable Integer idSuministro, @RequestBody Suministro suministro) {
        suministro.setIdSuministro(idSuministro);
        Suministro suministroActualizado = servicio.actualizarSuministro(suministro);
        return ResponseEntity.ok(suministroActualizado);
    }

    @DeleteMapping("/eliminarSuministro/{idSuministro}")
    public String eliminarSuministro(@PathVariable("idSuministro") Integer idSuministro) {
        return servicio.eliminarSuministro(idSuministro);
    }
}
