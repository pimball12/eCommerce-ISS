package br.iss.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="IMAGEM")
public class Imagem extends GenericDomain {

	@Column(name="CAMINHO", length=100, nullable=false)
	private String caminho;
	
	@ManyToOne
	@JoinColumn(name="PRODUTO_ID", nullable=false)
	private Produto produto;
	
	@Column(name="POSICAO", nullable=false)
	private short posicao;

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public short getPosicao() {
		return posicao;
	}

	public void setPosicao(short posicao) {
		this.posicao = posicao;
	}
}
