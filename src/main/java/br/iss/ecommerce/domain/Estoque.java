package br.iss.ecommerce.domain;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ESTOQUE")
public class Estoque extends GenericDomain {
	
	@ManyToOne
	@JoinColumn(name="PRODUTO_ID", nullable=false)
	private Produto produto;
	
	@Column(name="QUANTIDADE", nullable=false)
	private short quantidade;	
	
	@Column(name="RESERVADO", nullable=false)
	private short reservado;
	
	@Column(name="PESO", nullable=false, precision=7, scale=2)
	private BigDecimal peso;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name = "ESTOQUE_ITEM_GRADE",  
		joinColumns = {
			@JoinColumn(name = "ESTOQUE_ID", nullable = false, updatable = false) 
		},
		inverseJoinColumns = { 
			@JoinColumn(name = "ITEM_GRADE_ID", nullable = false, updatable = false) 
		}
	)
	private Set<ItemGrade> itensGrade;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(short quantidade) {
		this.quantidade = quantidade;
	}

	public short getReservado() {
		return reservado;
	}

	public void setReservado(short reservado) {
		this.reservado = reservado;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Set<ItemGrade> getItensGrade() {
		return itensGrade;
	}

	public void setItensGrade(Set<ItemGrade> itensGrade) {
		this.itensGrade = itensGrade;
	}
	
}
