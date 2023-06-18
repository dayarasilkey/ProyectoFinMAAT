package com.example.maatizzz.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_categoria;
        @Column(nullable = false, length= 30)
        private String nombreCat;
        @Column(nullable = false, length= 30)
        private String tipoCat;
        @Column(nullable = false, length= 30)
        private String descripcionCat;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Productos> productos;

    public Categoria() {
    }

    public Categoria(Integer id_categoria, String nombreCat, String tipoCat, String descripcionCat) {
        this.id_categoria = id_categoria;
        this.nombreCat = nombreCat;
        this.tipoCat = tipoCat;
        this.descripcionCat = descripcionCat;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getTipoCat() {
        return tipoCat;
    }

    public void setTipoCat(String tipoCat) {
        this.tipoCat = tipoCat;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_categoria='" + id_categoria + '\'' +
                ", nombreCat='" + nombreCat + '\'' +
                ", tipoCat='" + tipoCat + '\'' +
                ", descripcionCat='" + descripcionCat + '\'' +
                '}';
    }

}
