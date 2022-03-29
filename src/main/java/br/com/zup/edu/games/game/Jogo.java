package br.com.zup.edu.games.game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private String link;

	public Jogo(String nome, String descricao, String link) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.link = link;
	}
	
	/**
	 * @deprecated construtor para uso exclusivo do hibernate
	 */
	@Deprecated
	public Jogo() {
		
	}

	public Long getId() {
		return id;
	}
	
}
