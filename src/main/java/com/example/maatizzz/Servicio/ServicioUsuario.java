package com.example.maatizzz.Servicio;

import com.example.maatizzz.Entidad.Usuario;
import com.example.maatizzz.Entidad.Rol;
import com.example.maatizzz.Repositorio.RepositorioUsuario;
import com.example.maatizzz.Repositorio.RepositorioRol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repositorioUsuario;
    private RepositorioRol RolRepo;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario, RepositorioRol rolRepo) {

        this.repositorioUsuario = repositorioUsuario;
        RolRepo = rolRepo;
    }

    public ArrayList<Usuario> ListarUsuario() {
        return (ArrayList<Usuario>) repositorioUsuario.findAll();
    }

    public Usuario buscarUsuario(Integer id_usuario) {
        if (repositorioUsuario.findById(id_usuario).isPresent())
            return repositorioUsuario.findById(id_usuario).get();
        else return null;
    }

    public ArrayList<Usuario> buscarNombreu(String nombre) {
        return repositorioUsuario.findByNombre(nombre);
    }

    public ArrayList<Usuario> buscarApellidou(String apellido) {
        return repositorioUsuario.findByApellido(apellido);
    }

    public ArrayList<Usuario> buscarNumdocumentou(String numdocumento) {
        return repositorioUsuario.findByNumdocumento(numdocumento);
    }

    public ArrayList<Usuario> buscarDireccionu(String direccion) {
        return repositorioUsuario.findByDireccion(direccion);
    }

    public ArrayList<Usuario> buscarTelefonou(String telefono) {
        return repositorioUsuario.findByTelefono(telefono);
    }

    public ArrayList<Usuario> buscarEmailu(String email) {
        return repositorioUsuario.findByEmail(email);
    }

    public ArrayList<Usuario> buscarContraseñau(String contraseña) {
        return repositorioUsuario.findByContraseña(contraseña);
    }

    public String agregarUsuario(Integer id_rol, String nombre, String apellido, String numdocumento, String direccion, String telefono, String email, String contraseña) {
        Optional<Rol> rolOptional = RolRepo.findById(id_rol);

        if (rolOptional.isPresent()){
            Rol rol = rolOptional.get();

            Usuario usuario = new Usuario(rol, nombre, apellido, numdocumento, direccion, telefono, email, contraseña);
            repositorioUsuario.save(usuario);
            return "Usuario Registrado exitosamente. ";
        }else {
            return "ERROR AL REGISTRAR USUARIO. usuario no encontrado";
        }
    }

    public Usuario actualizarUsuario(Usuario usuario) {

        Optional<Usuario> usuarioExistente = repositorioUsuario.findById(usuario.getId_usuario());
        if (usuarioExistente.isPresent()){
            //actualizar los datos del usuario existente
            Usuario usuarioActualizado = usuarioExistente.get();
            usuarioActualizado.setNombre(usuario.getNombre());
            usuarioActualizado.setApellido(usuario.getApellido());
            usuarioActualizado.setNumdocumento(usuario.getNumdocumento());
            usuarioActualizado.setDireccion(usuario.getDireccion());
            usuarioActualizado.setTelefono(usuario.getTelefono());
            usuarioActualizado.setEmail(usuario.getEmail());
            usuarioActualizado.setContraseña(usuario.getContraseña());

            return repositorioUsuario.save(usuarioActualizado);
        }else {
            throw new RuntimeException("El usuario no existe");
        }
    }

    public String eliminarUsuario(Integer id_usuario) {
        if (repositorioUsuario.existsById(Integer.valueOf(id_usuario))){
            repositorioUsuario.deleteById(Integer.valueOf(id_usuario));
            return "Usuario eliminado";
        } else {
            return "El Usuario no se encuentra registrado";
        }
    }


    //public boolean validarRegistro(Usuario usuario) {
//
    //    // Verificar si el correo electrónico ya existe en la base de datos
    //    boolean correoExistente=repositorioUsuario.existsByCorreocontra(usuario.getEmail(),usuario.getContraseña());
    //    return !correoExistente;
//
    //}
}


