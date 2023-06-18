package com.example.maatizzz.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="entrega")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrega;
    @Column(nullable = false, name = "fechae")
    @Temporal(TemporalType.DATE)
    private Date fechae;

    @PrePersist
    public void fechaactu(){
        this.fechae=new Date(); }
    @Column(nullable = false, name = "pedido", length = (100))
    private int numPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @OneToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    @JsonIgnore
    private Pedido pedido;

    //Es para decirle que antes de una excepcion o una  actualizacion haga eso->

    public Entrega() {
    }

    public Entrega(Integer id_entrega, Date fechae, int numPedido, Usuario usuario, Pedido pedido) {
        this.id_entrega = id_entrega;
        this.fechae = fechae;
        this.numPedido = numPedido;
        this.usuario = usuario;
        this.pedido = pedido;
    }

    public Entrega(Usuario usuario, Pedido pedido, Date fechae, int numPedido) {
        this.usuario = usuario;
        this.pedido = pedido;
        this.fechae = fechae;
        this.numPedido = numPedido;
    }

    public Integer getId_entrega() {
        return id_entrega;
    }

    public void setId_entrega(Integer id_entrega) {
        this.id_entrega = id_entrega;
    }

    public Date getFechae() {
        return fechae;
    }

    public void setFechae(Date fechae) {
        this.fechae = fechae;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id_entrega=" + id_entrega +
                ", fechae=" + fechae +
                ", numPedido=" + numPedido +
                ", usuario=" + usuario +
                ", pedido=" + pedido +
                '}';
    }
}
