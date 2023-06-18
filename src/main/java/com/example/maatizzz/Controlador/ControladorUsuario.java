package com.example.maatizzz.Controlador;

import com.example.maatizzz.Entidad.Usuario;
import com.example.maatizzz.Servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario servicio;

    public ControladorUsuario(ServicioUsuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarUsuario")
    public ArrayList<Usuario> ListarUsuario(){
        return servicio.ListarUsuario();
    }

    @GetMapping ("/buscarUsuario/{id_usuario}")
    Usuario buscarUsuario(@PathVariable("id_usuario")Integer id_usuario){
        return  servicio.buscarUsuario(id_usuario);
    }

    @GetMapping ("/buscarNombreu/{nombre}")
    public ArrayList<Usuario> buscarNombre(@PathVariable("nombre")String n){
        return servicio.buscarNombreu(n);
    }

    @GetMapping ("/buscarApellidou/{apellido}")
    public ArrayList<Usuario> buscarApellido(@PathVariable("apellido")String a){
        return servicio.buscarApellidou(a);
    }

    @GetMapping ("/buscarNumdocumentou/{numdocumento}")
    public ArrayList<Usuario> buscarNumdocumento(@PathVariable("numdocumento")String u){
        return servicio.buscarNumdocumentou(u);
    }

    @GetMapping ("/buscarDireccionu/{direccion}")
    public ArrayList<Usuario> buscarDireccion(@PathVariable("direccion")String d){
        return servicio.buscarDireccionu(d);
    }

    @GetMapping ("/buscarTelefonou/{telefono}")
    public ArrayList<Usuario> buscarTelefono(@PathVariable("telefono")String t){
        return servicio.buscarTelefonou(t);
    }

    @GetMapping ("/buscarEmailu/{email}")
    public ArrayList<Usuario> buscarEmail(@PathVariable("email")String e){
        return servicio.buscarEmailu(e);
    }

    @GetMapping ("/buscarContraseñau/{contraseña}")
    public ArrayList<Usuario> buscarContraseña(@PathVariable("contraseña")String c){
        return servicio.buscarContraseñau(c);
    }

    @PostMapping("/agregarUsuario/{id_rol}")
    public String agregarUsuario(@PathVariable("id_rol") Integer id_rol,
                                 @RequestParam("nombre") String nombre,
                                 @RequestParam("apellido") String apellido,
                                 @RequestParam("numdocumento") String numdocumento,
                                 @RequestParam("direccion") String direccion,
                                 @RequestParam("telefono") String telefono,
                                 @RequestParam("email") String email,
                                 @RequestParam("contraseña") String contraseña){

        return servicio.agregarUsuario(id_rol, nombre, apellido, numdocumento, direccion, telefono, email, contraseña);
    }

    @PutMapping("/actualizarUsuario/{id_usuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id_usuario, @RequestBody Usuario usuario) {
        usuario.setId_usuario(id_usuario);
        Usuario usuarioActualizado = servicio.actualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/eliminarUsuario/{id_usuario}")
    public String eliminarUsuario(@PathVariable("id_usuario") Integer id_usuario){
        return servicio.eliminarUsuario(id_usuario);
    }
//
    //@PostMapping("/validarregistro")
    //public String registroUsuario(@RequestBody Usuario usuario) {
    //    if (!servicio.validarRegistro(usuario)) {
    //        return "El correo electrónico y contraseña ya están registrados";
    //    }
    //    // Guardar el usuario en la base de datos utilizando el repositorio
    //    repo.save(usuario);
    //    return "Registro exitoso";
    //}
//

}
