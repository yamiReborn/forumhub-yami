package com.exemplo.forum.controller;

import com.exemplo.forum.model.Topico;
import com.exemplo.forum.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listar() {
        return topicoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Topico> criar(@Valid @RequestBody Topico topico) {
        return new ResponseEntity<>(topicoService.criarTopico(topico), HttpStatus.CREATED);
    }
}
