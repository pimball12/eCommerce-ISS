package br.iss.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="USUARIO")
public class Usuario extends GenericDomain {

	@Column(name="EMAIL", length=75, nullable=false)
	private String email;
	
	@Column(name="SENHA", length=50, nullable=false)
	private String senha;
	
	@Column(name="TIPO", nullable=false)
	private char tipo;
	
	@OneToOne
	@JoinColumn(name="PESSOA_ID")
	private Pessoa pessoa;

	public Usuario() {
		this.pessoa = new Pessoa();
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
