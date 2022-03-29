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
@RequestMapping("/games")
public class CadastrarNovoJogoController {
	private final JogoRepository repository;
	
	public CadastrarNovoJogoController(JogoRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody @Valid JogoDTO request, UriComponentsBuilder uriComponentsBuilder){
		Jogo novoJogo = request.paraJogo();
		
		repository.save(novoJogo);
		
		URI location = uriComponentsBuilder.path("/games/{id}").buildAndExpand(novoJogo.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
