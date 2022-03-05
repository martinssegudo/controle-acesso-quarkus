package br.com.quarkus.userCase;

import br.com.quarkus.userCase.exception.CreateException;

import java.util.List;

public interface BaseUserCase<T> {
    void save(T t);
    T findById(Long id) throws CreateException;
    List<T> findAll();
}
