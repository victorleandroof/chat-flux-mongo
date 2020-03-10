package br.com.victorleandro.repository;

import br.com.victorleandro.models.Canal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CanalRepository extends ReactiveMongoRepository<Canal, String>{

}
