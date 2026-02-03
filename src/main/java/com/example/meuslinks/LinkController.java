package com.example.meuslinks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LinkController {

    private final LinkRepository repository;

    // Injeção de Dependência via Construtor
    public LinkController(LinkRepository repository) {
        this.repository = repository;
    }

    // 1. Rota para abrir a página inicial
    @GetMapping("/")
    public String index(Model model) {
        // Busca todos os links no banco e manda pro HTML com o nome "listaLinks"
        model.addAttribute("listaLinks", repository.findAll());
        return "index"; // Vai procurar um arquivo index.html
    }

    // 2. Rota para abrir a página de cadastro
    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("link", new Link()); // Manda um objeto vazio pra ser preenchido
        return "formulario"; // Vai procurar um arquivo formulario.html
    }

    // 3. Rota para RECEBER os dados do formulário e salvar
    @PostMapping("/salvar")
    public String salvar(Link link) {
        repository.save(link); // Salva no banco
        return "redirect:/"; // Volta para a página inicial
    }
}