package br.com.fuctura.biblioteca.dtos;

import br.com.fuctura.biblioteca.models.Livro;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto {

    private Integer id;

    @NotNull
    @Length(min = 3, max = 20, message = "O campo Nome deve conter entre 3 e 20 caracteres")
    private String nome;

    @NotNull
    @Length(min = 10, max = 50, message = "O campo Descrição deve conter entre 10 e 50 caracteres")
    private String descricao;

    private String senha;


    //private List<Livro> livros = new ArrayList<>();

    public CategoriaDto() {
    }

    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
