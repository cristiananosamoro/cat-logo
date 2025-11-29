package com.example.vitrine.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.vitrine.model.Produto;
import com.example.vitrine.service.CatalogoService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class CatalogoController {
    @Autowired
    private CatalogoService service;

    @GetMapping("/")
    public String listarProdutos(
        @RequestParam(required = false) String busca,
        Model model){
            List<Produto> listadeProdutos;
            if(busca != null && !busca.isEmpty()){
                listadeProdutos = service.buscarPorNome(busca);
            }
            else{
                listadeProdutos = service.buscarTodos();
            }
            model.addAttribute("produtos", listadeProdutos);
            model.addAttribute("termoBusca", busca);

            return "catalogo";
        }
        @GetMapping("/produto/{id}")
        public String detalheProduto(
            @PathVariable Long id, Model model
        ) {
            Produto produto = service.buscarPorId(id);
            if (produto == null) {
                return "redirect:/";
            }
            model.addAttribute("produto", produto);
            return "detalhe";
        }
        @GetMapping("/cadastro")
        public String exibirFormularioCadastro(
            Model model) 
             {
                model.addAttribute("produto", new Produto());
                System.out.println("  ok   ");
            return "cadastro";
        }
        
        @GetMapping("/produto/editar/{id}")
        public String exibirFormularioEdicao(@PathVariable Long id, Model model) 
        {
            Produto produto = service.buscarPorId(id);
            if (produto == null) {
                return "redirect:/";
            }
            model.addAttribute("produto", produto);
            return "cadastro";
        }
        @PostMapping("/cadastro")
        public String salvarProduto(Produto produto) {
            service.salvar(produto);
            return "redirect:/";
        }
        @PostMapping("/produto/excluir/{id}")
        public String excluirProduto(@PathVariable Long id) {
            service.excluir(id);
            return "redirect:/";
        }
        
        
        
}
