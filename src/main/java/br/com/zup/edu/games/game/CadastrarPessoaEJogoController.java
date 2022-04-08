package br.com.zup.edu.games.game;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class CadastrarPessoaEJogoController {
	
	private final PessoaRepository repository;
	private final JogoRepository jogoRepository;
	
	public CadastrarPessoaEJogoController(PessoaRepository repository, JogoRepository jogoRepository) {
		this.repository = repository;
		this.jogoRepository = jogoRepository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid PessoaComJogoRequest request, UriComponentsBuilder uriComponentsBuilder){
		
		System.out.println("Antes: "+request.getNome());
		System.out.println("Antes: "+request.getJogos());
		
		Pessoa pessoa = request.paraPessoa(jogoRepository);
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getJogos());
		
		repository.save(pessoa);
		
		URI location = uriComponentsBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
