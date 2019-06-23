package com.teste.courart.repository;

import com.teste.courart.model.Usuario;
import com.teste.courart.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findByPessoaCpf(String cpf);
    List<Usuario> findByPessoaNomeContaining(String nome);

}
