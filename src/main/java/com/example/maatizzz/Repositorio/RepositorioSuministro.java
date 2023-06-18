package com.example.maatizzz.Repositorio;

import com.example.maatizzz.Entidad.Suministro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RepositorioSuministro extends JpaRepository<Suministro, Integer> {
    ArrayList<Suministro> findBydescripcionSuministro(String descripcionSuministro);
    ArrayList<Suministro> findBynombreSum(String nombreSum);

    @Query(value="select * from suministros where stock = :dato", nativeQuery = true)
    List<Object[]> findBystocksum(Integer dato);



}
