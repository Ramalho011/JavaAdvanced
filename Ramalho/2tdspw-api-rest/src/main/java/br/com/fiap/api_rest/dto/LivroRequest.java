package br.com.fiap.api_rest.dto;

import br.com.fiap.api_rest.model.Categoria;
import jakarta.validation.constraints.*;

import java.util.List;

public class LivroRequest {
    @NotBlank(message = "O título não pode ser nulo ou vazio")
    @Size(min = 3, max = 254, message = "O título deve ter entre 3 e 254 caracteres")
    private String titulo;
    @NotNull(message = "O autor não pode ser nulo")
    private List<AutorRequest> autores;
    @Min(value = 1, message = "O preço deve ser no mínimo 1")
    @Max(value = 99, message = "O preço deve ser no máximo 99")
    private int preco;
    @NotNull(message = "A categoria é obrigatória")
    private Categoria categoria;
    @Pattern(regexp = "^970\\d{10}$|^970\\d{7}$", message = "O ISBN deve ter 10 OU 13 dígitos e iniciar por 970")
    private String isbn;
    @NotNull(message = "O id da biblioteca é obrigatório")
    private Long biblioteca;
    @NotNull(message = "O número do exemplar é obrigatório")
    private int numeroExemplar;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<AutorRequest> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorRequest> autores) {
        this.autores = autores;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Long getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Long biblioteca) {
        this.biblioteca = biblioteca;
    }

    public int getNumeroExemplar() {
        return numeroExemplar;
    }

    public void setNumeroExemplar(int numeroExemplar) {
        this.numeroExemplar = numeroExemplar;
    }
}
