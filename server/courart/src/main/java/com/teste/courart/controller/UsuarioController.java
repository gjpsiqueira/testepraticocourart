package com.teste.courart.controller;

import com.teste.courart.model.Pessoa;
import com.teste.courart.model.Usuario;
import com.teste.courart.repository.PessoaRepository;
import com.teste.courart.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public Usuario create(@RequestBody Usuario usuario) {
        Pessoa p = pessoaRepository.save(usuario.getPessoa());

        return usuarioRepository.save(usuario);

    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/cpf/{cpf}")
    public ResponseEntity<Usuario> getUsuarioByCpf(@PathVariable("cpf") String cpf) {
        Usuario usuario =  usuarioRepository.findByPessoaCpf(cpf);
        if(usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/nome/{nome}")
    public ResponseEntity<List<Usuario>> getUsuariosByNome(@PathVariable("nome") String nome) {
        List<Usuario> usuario = usuarioRepository.findByPessoaNomeContaining(nome);

        if(!usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
