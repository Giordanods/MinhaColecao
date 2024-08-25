package com.giordanods.colecao.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Deck {
	
	@Id
	private Long id;
	
	private String nome;
	
	private int vitorias;
	
	private int derrotas;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jogadorId")
	private Jogador jogador;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "cartasDeck", joinColumns = @JoinColumn(name = "deckId"), 
        	inverseJoinColumns = @JoinColumn(name = "cartaId"))
	private List<Carta> cartas;
	

}
