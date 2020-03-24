package br.com.dev.javaee.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Livro
 *
 */
@Entity(name ="LIVRO")

public class Livro implements Serializable {

	   
	@Id
	private Integer id;
	
	@Column(name = "NOME",length = 60, nullable = false)
	private String nome;
	
	@Column(name = "AUTOR", length = 60, nullable = false)
	private String autor;
	
	@Column(name = "NUMPAGINAS", nullable = false)
	private Integer numPaginas;


	   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}   
	public Integer getNumPaginas() {
		return this.numPaginas;
	}

	public void setNumPaginas(Integer numPaginas) {
		this.numPaginas = numPaginas;
	}
   
}
