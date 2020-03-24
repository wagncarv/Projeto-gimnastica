package br.com.dev.javaee.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
public class Cliente implements Serializable {
	

	@Id
	private int id;

	private String nome;

	@Column(name="receber_emails")
	private byte receberEmails;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte getReceberEmails() {
		return this.receberEmails;
	}

	public void setReceberEmails(byte receberEmails) {
		this.receberEmails = receberEmails;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setCliente(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setCliente(null);

		return endereco;
	}

}