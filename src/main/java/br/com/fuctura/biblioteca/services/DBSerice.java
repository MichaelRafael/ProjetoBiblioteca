package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBSerice {

    @Autowired
    private CategoriaRepository categoriaReository;



}
