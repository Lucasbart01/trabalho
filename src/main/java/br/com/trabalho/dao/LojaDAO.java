package br.com.trabalho.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.trabalho.beans.Loja;

public interface LojaDAO extends CrudRepository<Loja, Integer> {

}
