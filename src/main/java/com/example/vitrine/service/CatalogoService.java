package com.example.vitrine.service;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.vitrine.model.Produto;

@Service
public class CatalogoService {
    private List<Produto> produtos = new ArrayList<>();
    private long proximoId = 1L;
    public CatalogoService(){}

    public void salvar(Produto produto){
        
    }
}
