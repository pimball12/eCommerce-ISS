package br.iss.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ENDERECO")
public class Endereco extends GenericDomain {
	
	@Column(name="PAIS", length=30, nullable=false)
	private String pais;
	
	@Column(name="CEP", length=15, nullable=false)
	private String cep;
	
	@Column(name="RUA", length=100, nullable=false)
	private String rua;
	
	@Column(name="NUMERO", length=10, nullable=false)
	private String numero;
	
	@Column(name="COMPLEMENTO", length=100, nullable=true)
	private String complemento;
	
	@Column(name="BAIRRO", length=100, nullable=false)
	private String bairro;
	
	@Column(name="CIDADE", length=50, nullable=false)
	private String cidade;
	
	@Column(name="ESTADO", length=10, nullable=false)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="PESSOA_ID")
	private Pessoa pessoa;

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
