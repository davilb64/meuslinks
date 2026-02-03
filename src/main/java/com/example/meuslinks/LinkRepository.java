package com.example.meuslinks;

import org.springframework.data.jpa.repository.JpaRepository;

// <Tipo da Classe, Tipo do ID>
public interface LinkRepository extends JpaRepository<Link, Long> {
    // Só isso. O Spring cria todo o SQL (save, find, delete) magicamente.
}