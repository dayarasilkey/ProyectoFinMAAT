package com.example.maatizzz.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "detallepedido")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetallePedido;
    @Column(nullable = false, name = "cantidad", length = (100))
    private int cantidad;
    @Column(nullable = false, name = "precioCantidad", length = (100))
    private int precioCantidad;
    @Column(nullable = false, name = "descuento", length = (100))
    private int descuento;
    @Column(nullable = false, name = "numPedido", length = (100))
    private int numPedido;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY, optional= false)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @JsonIgnore
    private Productos productos;


     public DetallePedido() {
     }

    public DetallePedido(Integer idDetallePedido, int cantidad, int precioCantidad, int descuento, int numPedido, Pedido pedido, Productos productos) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.precioCantidad = precioCantidad;
        this.descuento = descuento;
        this.numPedido = numPedido;
        this.pedido = pedido;
        this.productos = productos;
    }

    public DetallePedido(Pedido pedido, Productos productos, int cantidad, int precioCantidad, int descuento, int numPedido) {
        this.pedido = pedido;
        this.productos = productos;
        this.cantidad = cantidad;
        this.precioCantidad = precioCantidad;
        this.descuento = descuento;
        this.numPedido = numPedido;

    }

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioCantidad() {
        return precioCantidad;
    }

    public void setPrecioCantidad(int precioCantidad) {
        this.precioCantidad = precioCantidad;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "DetallePedido{" +
                "idDetallePedido=" + idDetallePedido +
                ", cantidad=" + cantidad +
                ", precioCantidad=" + precioCantidad +
                ", descuento=" + descuento +
                ", numPedido=" + numPedido +
                ", pedido=" + pedido +
                ", productos=" + productos +
                '}';
    }
}
