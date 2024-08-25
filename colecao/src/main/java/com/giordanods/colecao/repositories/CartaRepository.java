package com.giordanods.colecao.repositories;

import org.springframework.data.repository.CrudRepository;

import com.giordanods.colecao.entities.Carta;

public interface CartaRepository extends CrudRepository<Carta, Long>{
    
}
