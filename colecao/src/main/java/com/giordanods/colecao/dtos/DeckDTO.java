package com.giordanods.colecao.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeckDTO {
    
    private Long id;
	
	private String nome;
	
	private int vitorias;
	
	private int derrotas;

    private int idJogador;
}
