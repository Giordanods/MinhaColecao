package com.giordanods.colecao.controllers;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giordanods.colecao.dtos.DeckDTO;
import com.giordanods.colecao.entities.Carta;
import com.giordanods.colecao.entities.Deck;
import com.giordanods.colecao.entities.Jogador;
import com.giordanods.colecao.repositories.CartaRepository;
import com.giordanods.colecao.repositories.DeckRepository;
import com.giordanods.colecao.repositories.JogadorRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/deck")
public class DeckController {

    @Autowired
    private DeckRepository deckRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private CartaRepository cartaRepository;

    @PostMapping("criarDeck")
    public String criarDeck(@RequestBody DeckDTO deckDto) {

        Optional<Jogador> jogador = jogadorRepository.findById((long) deckDto.getIdJogador());

        if (jogador.isPresent()){
            Deck entity = new Deck(deckDto.getId(), deckDto.getNome(), deckDto.getVitorias(), deckDto.getDerrotas(), jogador.get(), null);
            deckRepository.save(entity);
        } else {
            return "Jogador não encontrado";
        }
            
        
        return "Cadastrado com sucesso";
    }
    
    @PostMapping("adicionarCartaNoDeck/{idDeck}/{idCarta}")
    public String adicionarCartaDeck(@PathVariable Long idCarta, @PathVariable Long idDeck) {
        
        Optional<Carta> carta = cartaRepository.findById(idCarta);
        Optional<Deck> deck = deckRepository.findById(idDeck);

        if (carta.isPresent() && deck.isPresent()){
            deck.get().getCartas().add(carta.get());
            deckRepository.save(deck.get());
        }
        return "carta adicionada com sucesso";
    }

    @GetMapping("{idDeck}")
    public Deck getMethodName(@PathVariable Long idDeck) {
        Optional<Deck> deck = deckRepository.findById(idDeck);


        if (deck.isPresent()) {
            return deck.get();
        }

        return null;
    }
    
    
    
}
