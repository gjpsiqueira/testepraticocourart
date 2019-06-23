package com.teste.courart.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.teste.courart.model.Modelo;
import com.teste.courart.model.Pessoa;
import com.teste.courart.model.Veiculo;
import com.teste.courart.repository.ModeloRepository;
import com.teste.courart.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private ModeloRepository modeloRepository;


    @CrossOrigin
    @RequestMapping(method= RequestMethod.GET,value = "/placa/{placa}")
    public ResponseEntity<Veiculo> getVeiculoByPlaca(@PathVariable("placa") String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa);
        if(veiculo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(veiculo);

    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET,value = "/modelo/{id}")
    public ResponseEntity<List<Veiculo>> getVeiculosByModelo(@PathVariable("id") String id) {
        List<Veiculo> veiculo = veiculoRepository.findByModeloDescricaoContaining(id);

        if(!veiculo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(veiculo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public Veiculo create(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/dt/{start}/{end}")
    public ResponseEntity<List<Veiculo>> getPessoaByDtCadastro(@PathVariable("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
                                                                @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("end") Date end) {
        List<Veiculo> veiculo = veiculoRepository.getAllBetweenDates(start,end);

        if(!veiculo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(veiculo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
