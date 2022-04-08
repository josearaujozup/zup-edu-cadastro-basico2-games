package br.com.zup.edu.games.game;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private Set<Jogo> jogos = new HashSet<>();
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @deprecated construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Pessoa() {
		
	}
	
	public void adicionar(Set<Jogo> novosJogos) {
		this.jogos.addAll(novosJogos);
		novosJogos.stream().peek(jogo -> jogo.adicionar(this));
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Set<Jogo> getJogos() {
		return jogos;
	}
	
	
}
