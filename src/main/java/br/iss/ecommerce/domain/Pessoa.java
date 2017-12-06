package br.iss.ecommerce.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="PESSOA")
public class Pessoa extends GenericDomain {

	@Column(name="NOME", length=50, nullable=false)
	private String nome;
	
	@Column(name="SOBRENOME", length=80, nullable=false)
	private String sobrenome;
	
	@Column(name="TELEFONE", length=25, nullable=false)
	private String telefone;
	
	@Column(name="CPF", length=15, nullable=false)
	private String cpf;
	
	@OneToOne
	@JoinColumn(name="PRINCIPAL_ENDERECO_ID", nullable=false)
	private Endereco enderecoPrincial;
	
	@OneToMany(mappedBy="pessoa")
	private Set<Endereco> enderecos;

	publlic Pessoa() {
		this.enderecoPrincial = new Endereco();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEnderecoPrincial() {
		return enderecoPrincial;
	}

	public void setEnderecoPrincial(Endereco enderecoPrincial) {
		this.enderecoPrincial = enderecoPrincial;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
