package br.com.zup.edu.games.game;

import javax.validation.constraints.NotBlank;

public class JogoDTO {
	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	@NotBlank
	private String link;
	
	public JogoDTO(@NotBlank String nome, @NotBlank String descricao, @NotBlank String link) {
		this.nome = nome;
		this.descricao = descricao;
		this.link = link;
	}
	
	public Jogo paraJogo() {
		return new Jogo(nome, descricao, link);
	}
	
	public JogoDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getLink() {
		return link;
	}
	
}
