package com.example.vitrine.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.vitrine.model.Produto;
import com.example.vitrine.service.CatalogoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
 
}
