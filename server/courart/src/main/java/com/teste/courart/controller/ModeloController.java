package com.teste.courart.controller;

import com.teste.courart.model.Modelo;
import com.teste.courart.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/modelos")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<Modelo> getAll() {
        return modeloRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Modelo modelo) {
        modeloRepository.save(modelo);
    }
}
