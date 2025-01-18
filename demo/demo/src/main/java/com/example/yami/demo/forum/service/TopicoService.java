package com.exemplo.forum.service;

import com.exemplo.forum.model.Topico;
import com.exemplo.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> listarTodos() {
        return topicoRepository.findAll();
    }

    public Topico criarTopico(Topico topico) {
        return topicoRepository.save(topico);
    }
}
