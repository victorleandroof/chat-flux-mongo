package br.com.victorleandro.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "canais")
public class Canal {
	@Id
	private String id;
	@Field
	private String primeiroUsuario;
	@Field
	private String segundoUsuario;

	public Canal() {
	}

	public Canal(String primeiroUsuario, String segundoUsuario) {
		this.primeiroUsuario = primeiroUsuario;
		this.segundoUsuario = segundoUsuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrimeiroUsuario() {
		return primeiroUsuario;
	}

	public void setPrimeiroUsuario(String primeiroUsuario) {
		this.primeiroUsuario = primeiroUsuario;
	}

	public String getSegundoUsuario() {
		return segundoUsuario;
	}

	public void setSegundoUsuario(String segundoUsuario) {
		this.segundoUsuario = segundoUsuario;
	}
}
