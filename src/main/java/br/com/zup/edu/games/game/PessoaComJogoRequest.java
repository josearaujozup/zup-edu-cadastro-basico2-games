package br.com.zup.edu.games.game;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PessoaComJogoRequest {
	
	@NotBlank
	private String nome;
	
	@NotNull
	private Set<Long> jogos;
	
	public PessoaComJogoRequest() {
		
	}
	
	public PessoaComJogoRequest(String nome, Set<Long> jogos) {
		this.nome = nome;
		this.jogos = jogos;
	}
	
	
	
//	public Pessoa paraPessoa(JogoRepository jogoRepository) {	
//	
//		Set<Jogo> games = jogos.stream().map(id -> jogoRepository.findById(id)
//				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo nao cadastrado"))
//				.collect(Collectors.toSet());
//				
//		Pessoa pessoa = new Pessoa(nome);
//		pessoa.adicinar(games);
//		
//		return pessoa;
//	}
	
	
	public Pessoa paraPessoa(JogoRepository jogoRepository) {
        Set<Jogo> games = this.jogos.stream()
                .map(idJogo -> jogoRepository.findById(idJogo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não cadastrado")))
                .collect(Collectors.toSet());
        
        Pessoa pessoa = new Pessoa(nome);
        
        pessoa.adicionar(games);

        return pessoa;
    }
	
	

	public String getNome() {
		return nome;
	}

	public Set<Long> getJogos() {
		return jogos;
	}
	
}
