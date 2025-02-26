package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.LivroRequest;
import br.com.fiap.api_rest.dto.LivroResponse;
import br.com.fiap.api_rest.model.Livro;
import br.com.fiap.api_rest.repository.LivroRepository;
import br.com.fiap.api_rest.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroService livroService;

    // CREATE, READ, UPDATE, DELETE
    // POST, GET, PUT, DELETE

    @PostMapping
    public ResponseEntity<Livro> createLivro(@Valid @RequestBody LivroRequest livro) {
        Livro livroSalvo = livroRepository.save(livroService.requestToLivro(livro));
        return new ResponseEntity<>(livroSalvo,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<BookRes>> readLivros(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "2") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("title").ascending());
        Page<Book> pageLivros = bookRepository.findAll(pageable);
        Page<BookRes> listaLivrosRes = bookService.pageToRes(pageLivros);
        for (LivroResponse livro: livros)
            livro.setLink(
                    linkTo(
                            method0n(LivroController.class)
                                    .readLivro(livro.getId())
                    )
            )
        return new ResponseEntity<>(listaLivrosRes, HttpStatus.OK);
    }

    // @PathVariable localhost:8080/livros/1
    // @RequestParam localhost:8080/livros/?id=1
    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> readLivro(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LivroResponse livroResponse = livroService.livroToResponse(livro.get());
        Object pageNumber;
        livroResponse.setLink(
                linkTo(
                        method0n(LivroController.class)
                                .readLivro(pageNumber:0)
                ).withReal("lista de livros")

        );
        return new ResponseEntity<>(livroService.livroToResponse(livro.get()),HttpStatus.OK);
    }

    private Object linkTo(ResponseEntity<LivroResponse> livroResponseResponseEntity) {
    }

    private LivroController method0n(Class<LivroController> livroControllerClass) {
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id,
                                             @RequestBody LivroRequest livro) {
        Optional<Livro> livroExistente = livroRepository.findById(id);
        if (livroExistente.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Livro livroConvertido = livroService.requestToLivro(livro);
        livroConvertido.setId(livroExistente.get().getId());
        Livro livroSalvo = livroRepository.save(livroConvertido);
        return new ResponseEntity<>(livroSalvo,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
