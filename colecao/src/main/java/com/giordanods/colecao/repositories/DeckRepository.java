package com.giordanods.colecao.repositories;

import org.springframework.data.repository.CrudRepository;

import com.giordanods.colecao.entities.Deck;
import java.util.Optional;


public interface DeckRepository extends CrudRepository<Deck, Long>{

    Optional<Deck> findById(Long id);


    
}
