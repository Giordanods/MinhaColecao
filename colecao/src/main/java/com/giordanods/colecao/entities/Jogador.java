package com.giordanods.colecao.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jogador {
	
	@Id
	private Long id;
	
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jogador", cascade = CascadeType.ALL)
	private List<Deck> decks;

}
