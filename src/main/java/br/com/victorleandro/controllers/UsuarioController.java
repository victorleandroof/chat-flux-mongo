package br.com.victorleandro.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorleandro.models.Usuario;
import br.com.victorleandro.repository.UsuarioRepository;

import reactor.core.publisher.Mono;

@RestController
public class UsuarioController {

	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@PostMapping("/usuarios")
	public Mono<Usuario> salvarUsuario(@Valid @RequestBody Usuario usuario){
		return usuarioRepository.save(usuario);
	}

	@GetMapping("/usuarios/{id}")
	public Mono<ResponseEntity<Usuario>> buscaUsuarioPorId(@PathVariable String id){
		return usuarioRepository.findById(id).map(usuario -> ResponseEntity.ok(usuario))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
