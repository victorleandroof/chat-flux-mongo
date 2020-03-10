package br.com.victorleandro.repository;

import br.com.victorleandro.models.Mensagem;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
@Repository
public interface MensagemRepository extends ReactiveMongoRepository<Mensagem, String> {
	@Tailable
	Flux<Mensagem> findByCanal(String canal);
}
