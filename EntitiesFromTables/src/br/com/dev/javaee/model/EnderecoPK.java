package br.com.dev.javaee.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the endereco database table.
 * 
 */
@Embeddable
public class EnderecoPK implements Serializable {
	//default serial version id, required for serializable classes.


	@Column(name="cliente_id", insertable=false, updatable=false)
	private int clienteId;

	private String rua;

	public EnderecoPK() {
	}
	public int getClienteId() {
		return this.clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getRua() {
		return this.rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EnderecoPK)) {
			return false;
		}
		EnderecoPK castOther = (EnderecoPK)other;
		return 
			(this.clienteId == castOther.clienteId)
			&& this.rua.equals(castOther.rua);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clienteId;
		hash = hash * prime + this.rua.hashCode();
		
		return hash;
	}
}