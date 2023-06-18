package com.example.maatizzz.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    @Column(nullable = false, length= 50)
    private String nombre;
    @Column(nullable = false, length= 50)
    private String apellido;
    @Column(nullable = false, length= 20)
    private String numdocumento;
    @Column(nullable = false, length= 50)
    private String direccion;
    @Column(nullable = false, length= 15)
    private String telefono;
    @Column(nullable = false, length= 50, unique  = true)
    private String email;
    @Column(nullable = false, length= 20)
    private String contraseña;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false)
    @JsonIgnore
    private Rol rol;


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Entrega> entrega;


    public Set<Entrega> getEntrega() {
        return entrega;
    }

    public void setEntrega(Set<Entrega> entrega) {
        this.entrega = entrega;
    }

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Pedido> pedido;

    public Set<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(Set<Pedido> pedido) {
        this.pedido = pedido;
    }

    public Usuario() {
    }

    public Usuario(Integer id_usuario, String nombre, String apellido, String numdocumento, String direccion, String telefono, String email, String contraseña, Rol rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numdocumento = numdocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Usuario(Rol rol, @JsonProperty("nombre") String nombre,@JsonProperty("apellido") String apellido,@JsonProperty("numdocumento") String numdocumento,@JsonProperty("direccion") String direccion,@JsonProperty("telefono") String telefono,@JsonProperty("email") String email,@JsonProperty("contraseña") String contraseña) {
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numdocumento = numdocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;

    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(String numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

//public Rol getRol() {
    //    return rol;
    //}
//
    //public void setRol(Rol rol) {
    //    this.rol = rol;
    //}


    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numdocumento='" + numdocumento + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", rol=" + rol +
                '}';
    }
}
