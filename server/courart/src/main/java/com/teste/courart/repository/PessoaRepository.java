package com.teste.courart.repository;

import com.teste.courart.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

    @Query(value = "from Pessoa t where dtNascimento BETWEEN :startDate AND :endDate")
    public List<Pessoa> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
