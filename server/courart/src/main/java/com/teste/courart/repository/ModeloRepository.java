package com.teste.courart.repository;

import com.teste.courart.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModeloRepository extends JpaRepository<Modelo,Integer> {

}
