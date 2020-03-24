package br.com.dev.javaee.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
public class Endereco implements Serializable {


	@EmbeddedId
	private EnderecoPK id;

	private String complemento;

	private int numero;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	public Endereco() {
	}

	public EnderecoPK getId() {
		return this.id;
	}

	public void setId(EnderecoPK id) {
		this.id = id;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}