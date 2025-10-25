package br.com.fuctura.biblioteca.services;

import br.com.fuctura.biblioteca.exceptions.ObjectNotFoundException;
import br.com.fuctura.biblioteca.models.Categoria;
import br.com.fuctura.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        }
        throw new ObjectNotFoundException("Categoria não encontrada com o ID: " + id);
    }

    public Categoria findByNome(String nome) {
        Optional<Categoria> categoria = categoriaRepository.findByNomeContainingIgnoreCase(nome);
        if (categoria.isPresent()) {
            return categoria.get();
        }
        throw new ObjectNotFoundException("Categoria não encontrada com o nome: " + nome);
    }

    public List<Categoria> findAll() {
        List<Categoria> list = categoriaRepository.findAll();
        return list;
    }

    public Categoria save(Categoria categoria) {
        buscarPorNome(categoria);
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public Categoria update(Categoria categoria) {
        findById(categoria.getId());
        buscarPorNome(categoria);
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public void delete(Integer id) {
        Categoria categoria = findById(id);
        if (!categoria.getLivros().isEmpty()) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada, pois possui livros associados.");
        }
        categoriaRepository.deleteById(id);
    }

    private void buscarPorNome(Categoria categoria) {
        Optional<Categoria> cat = categoriaRepository.findByNomeIgnoreCase(categoria.getNome());
        if (cat.isPresent()) {
            if (cat.get().getId() != categoria.getId()) {
                throw new IllegalArgumentException("Categoria já existe com o nome: " + categoria.getNome());
            }
        }
    }
}
