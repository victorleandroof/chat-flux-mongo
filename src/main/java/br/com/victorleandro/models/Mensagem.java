package br.com.victorleandro.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "teste")
public class Mensagem {

	@Id
	private String id;
	@Field
	private String mensagem;
	@Field
	private String origem;
	@Field
	private String destino;
	@Field
	private String canal;

	public Mensagem(String mensagem, String origem, String destino, String canal) {
		this.mensagem = mensagem;
		this.origem = origem;
		this.destino = destino;
		this.canal = canal;
	}

	public Mensagem() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}
}
