package br.com.fiap.api_rest.repository;

import br.com.fiap.api_rest.model.Livro;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Override
    default void flush() {

    }

    @Override
    default <S extends Livro> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    default <S extends Livro> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    default void deleteAllInBatch(Iterable<Livro> entities) {

    }

    @Override
    default void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    default void deleteAllInBatch() {

    }

    @Override
    default Livro getOne(Long aLong) {
        return null;
    }

    @Override
    default Livro getById(Long aLong) {
        return null;
    }

    @Override
    default Livro getReferenceById(Long aLong) {
        return null;
    }

    @Override
    default <S extends Livro> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    default <S extends Livro> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    default <S extends Livro> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    default List<Livro> findAll() {
        return List.of();
    }

    @Override
    default List<Livro> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    default <S extends Livro> S save(S entity) {
        return null;
    }

    @Override
    default Optional<Livro> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Livro entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Livro> entities) {

    }

    @Override
    default void deleteAll() {

    }

    @Override
    default List<Livro> findAll(Sort sort) {
        return List.of();
    }

    @Override
    default Page<Livro> findAll(Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Livro> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    default <S extends Livro> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    default <S extends Livro> long count(Example<S> example) {
        return 0;
    }

    @Override
    default <S extends Livro> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    default <S extends Livro, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
