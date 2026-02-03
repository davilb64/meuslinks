package com.example.meuslinks;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Isso avisa ao Spring que esta classe vai virar uma tabela no banco
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera ID automático (1, 2, 3...)
    private Long id;

    private String texto; // O nome do botão (ex: "Meu Instagram")
    private String url;   // O link (ex: "https://instagram.com/...")

    // Construtor Vazio (Obrigatório para o JPA)
    public Link() { }

    // Construtor para facilitar nossa vida
    public Link(String texto, String url) {
        this.texto = texto;
        this.url = url;
    }

    // Getters e Setters (Essenciais para o Thymeleaf ler os dados)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}