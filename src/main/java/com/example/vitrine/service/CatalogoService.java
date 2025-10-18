package com.example.vitrine.service;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.vitrine.model.Produto;

@Service
public class CatalogoService {
    private List<Produto> produtos = new ArrayList<>();
    private long proximoId = 1L;
    public CatalogoService(){}

    public void salvar(Produto produto){
        if (produto.getId() == null) {
            produto.setId(proximoId);
            produtos.add(produto);
        }
        else{
            excluir(produto.getId());
            produtos.add(produto);
        }
    }
    public Produto buscarPorId (Long id){
        return produtos.stream()
            .filter(p->p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    public void excluir(Long id){
        produtos.removeIf(p->p.getId().equals(id));
    }
    public List<Produto> buscarPorNome(String termoBusca){
        if (termoBusca == null || termoBusca.trim().isEmpty()) {
            return produtos;
        }
        String termoLowerCase = termoBusca.toLowerCase();
        return produtos.stream()
        .filter(p->p.getName().toLowerCase().contains(termoLowerCase))
        .collect(Collectors.toList());
    }
           public List<Produto> buscarTodos(){
            return produtos;
    }
}
