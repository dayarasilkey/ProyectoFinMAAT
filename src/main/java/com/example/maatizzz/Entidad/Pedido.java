package com.example.maatizzz.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @PrePersist
    public void fechaact(){this.fecha=new Date(); }

    @Column(nullable = false, name = "impuesto", length = (100))
    private int impuesto;

    @Column(nullable = false, name = "totalped", length = (100))
    private int totalped;
    @Column(nullable = false, length= 50)
    private String estadop;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Entrega entrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<DetallePedido> detallepedido;

    public Set<DetallePedido> getDetallepedido() {
        return detallepedido;
    }

    public void setDetallepedido(Set<DetallePedido> detallepedido) {
        this.detallepedido = detallepedido;
    }

    public Pedido() {
    }

    public Pedido(Integer id_pedido, Date fecha, int impuesto, int totalped, String estadop, Usuario usuario, Entrega entrega) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.totalped = totalped;
        this.estadop = estadop;
        this.usuario = usuario;
        this.entrega = entrega;
    }

    public Pedido(Usuario usuario, Date fecha, int impuesto, int totalped, String estadop) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.impuesto = impuesto;
        this.totalped = totalped;
        this.estadop = estadop;

    }

    public Integer getId_pedido() {
        return this.id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(int impuesto) {
        this.impuesto = impuesto;
    }

    public int getTotalped() {
        return totalped;
    }

    public void setTotalped(int totalped) {
        this.totalped = totalped;
    }

    public String getEstadop() {
        return estadop;
    }

    public void setEstadop(String estadop) {
        this.estadop = estadop;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", fecha=" + fecha +
                ", impuesto=" + impuesto +
                ", totalped=" + totalped +
                ", estadop='" + estadop + '\'' +
                ", usuario=" + usuario +
                ", entrega=" + entrega +
                '}';
    }
}
