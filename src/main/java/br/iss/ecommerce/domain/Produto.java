package br.iss.ecommerce.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name="PRODUTO")
public class Produto extends GenericDomain {

	@ManyToOne
	@JoinColumn(name="GRUPO_ID", nullable=false)
	private Grupo grupo;
	
	@Column(name="NOME", length=200)
	private String nome;
	
	@Column(name="DESCRICAO")
	@Type(type="text")
	private String descricao;
	
	@Column(name="PRECO", nullable=false, precision=7, scale=2)
	private BigDecimal preco;
	
	@Column(name="ATIVO", nullable=false)
	private Boolean ativo;
	
	@Column(name="DESTAQUE", nullable=false)
	private Boolean destaque;
	
	@Column(name="PESO_PADRAO", nullable=false, precision=7, scale=2)
	private BigDecimal pesoPadrao;
	
	@OneToMany(mappedBy="produto")
	private Set<Estoque> estoques;
	
	@OneToMany(mappedBy="produto")
	private Set<Imagem> imagens;

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getDestaque() {
		return destaque;
	}

	public void setDestaque(Boolean destaque) {
		this.destaque = destaque;
	}

	public BigDecimal getPesoPadrao() {
		return pesoPadrao;
	}

	public void setPesoPadrao(BigDecimal pesoPadrao) {
		this.pesoPadrao = pesoPadrao;
	}

	public Set<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(Set<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Set<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(Set<Imagem> imagens) {
		this.imagens = imagens;
	}
	
}
