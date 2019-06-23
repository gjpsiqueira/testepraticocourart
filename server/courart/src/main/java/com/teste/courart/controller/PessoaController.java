package com.teste.courart.controller;

import com.teste.courart.model.Pessoa;
import com.teste.courart.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/dt/{start}/{end}")
    public ResponseEntity<List<Pessoa>> getPessoaByDtNascimento(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                                                               @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("end") Date end) {
        List<Pessoa> pessoa = pessoaRepository.getAllBetweenDates(start,end);

        if(!pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(pessoa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
