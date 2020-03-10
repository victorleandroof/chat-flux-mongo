package br.com.victorleandro.controllers;

import javax.validation.Valid;

import br.com.victorleandro.models.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorleandro.models.Canal;
import br.com.victorleandro.repository.CanalRepository;
import br.com.victorleandro.repository.MensagemRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;

@RestController
public class MensagemController {

	private CanalRepository canalRepository;
	private MensagemRepository mensagemRepository;

	@Autowired
	public MensagemController(CanalRepository canalRepository, MensagemRepository mensagemRepository) {
		this.canalRepository = canalRepository;
		this.mensagemRepository = mensagemRepository;
	}

	@PostMapping("/chats")
	@ResponseStatus(HttpStatus.CREATED)
	public void enviarMensagem(@Valid @RequestBody Mensagem mensagem){
		 mensagemRepository.insert(mensagem).subscribe();
	}

	@PostMapping("/canais")
	public Mono<Canal> criarCanal(@Valid @RequestBody Canal canal){
		return canalRepository.save(canal);
	}

	@GetMapping(value = "/chats/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Mensagem> streamMensagens(@RequestParam String canalId){
		return mensagemRepository.findByCanal(canalId);
	}

}
