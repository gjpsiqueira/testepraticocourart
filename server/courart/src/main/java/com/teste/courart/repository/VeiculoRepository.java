package com.teste.courart.repository;

import com.teste.courart.model.Modelo;
import com.teste.courart.model.Pessoa;
import com.teste.courart.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

    Veiculo findByPlaca(String placa);

    Veiculo findByModelo(Modelo modelo);

    List<Veiculo> findByModeloId(int id);

    List<Veiculo> findByModeloDescricaoContaining(String descricao);

    @Query(value = "from Veiculo t where dataCadastro BETWEEN :startDate AND :endDate AND ativo = true")
    public List<Veiculo> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);

}
