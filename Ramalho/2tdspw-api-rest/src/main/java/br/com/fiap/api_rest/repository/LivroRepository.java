package br.com.fiap.api_rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Collection;
import java.util.Date;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTitulo(String titulo);
    List<Livro> findTop3ByPreco();
    List<Livro> findByIsbnIsNull();
    List<Livro> findByAutorStartingWith(String prefix);
    List<Livro> findByPrecoBetween(double min, double max);
    List<Livro> findByTituloOrAutor(String titulo, String autor);
    List<Livro> findByTituloOrAutorAndEditora(String titulo, String autor, String editora);
    List<Livro> findByTituloOrderByTituloAsc(String titulo);
    List<Livro> findByTituloOrderByTituloDesc(String titulo);
    List<Livro> findByPrecoLessThan(double preco);
    List<Livro> findByPrecoGreaterThan(double preco);
    List<Livro> findByPrecoLessThanEqual(double preco);
    List<Livro> findByPrecoGreaterThanEqual(double preco);
    List<Livro> findByEbookTrue();
    List<Livro> findByEbookFalse();
    List<Livro> findByTituloLike(String likePattern);
    List<Livro> findByTituloNotLike(String likePattern);
    List<Livro> findByDataLancamentoBefore(Date dataLancamento);
    List<Livro> findByDataLancamentoAfter(Date dataLancamento);
    List<Livro> findByDataLancamentoBetween(Date dataLancamentoInicial, Date dataLancamentoFinal);
    List<Livro> findByTituloIn(Collection<String> livros);
}