package br.com.dev.javaee.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Carro extends VeiculoPasseio {

	private Integer qtdePortas;

	public Integer getQtdePortas() {
		return qtdePortas;
	}

	public void setQtdePortas(Integer qtdePortas) {
		this.qtdePortas = qtdePortas;
	}
}
