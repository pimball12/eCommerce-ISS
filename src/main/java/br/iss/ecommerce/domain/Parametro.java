package br.iss.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="PARAMETRO")
public class Parametro extends GenericDomain {

	@Column(name="EMAIL", length=70)
	private String email;

	@OneToOne
	@JoinColumn(name="REMETENTE_ENDERECO_ID")
	private Endereco remetente;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getRemetente() {
		return remetente;
	}

	public void setRemetente(Endereco remetente) {
		this.remetente = remetente;
	}
	
}
