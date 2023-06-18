package com.example.maatizzz.Repositorio;

import com.example.maatizzz.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, Integer> {
    ArrayList<Pedido> findByEstadop(String estadop);

    //@Query(value = "select p.id_pedido, p.fecha, p.impuesto, p.totalped, p.estadop, u.id_usuario, u.nombre, u.apellido, u.numdocumento, u.direccion, u.telefono, u.email, u.contraseña from pedido as p inner join usuario as u on p.id_pedido=u.id_usuario where p.id_pedido= :usu")
    //List<Object[]> findPedidousuario(String usu);

    //@Query(value = "select p.id_pedido, p.fecha, p.impuesto, p.totalped, p.estadop, e.id_entrega, e.fechae, e.numPedido from pedido as p inner join entrega as e on p.id_pedido=e.id_entrega where p.id_pedido= :ent")
    //List<Object[]> findPedidoEntrga(String ent);

}
