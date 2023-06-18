package com.example.maatizzz.Repositorio;

import com.example.maatizzz.Entidad.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDetallePedido extends JpaRepository<DetallePedido, Integer> {

}
