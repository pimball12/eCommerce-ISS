package br.iss.ecommerce.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ITEM_PEDIDO")
public class ItemPedido extends GenericDomain {

	@ManyToOne
	@JoinColumn(name="ESTOQUE_ID", nullable=false)
	private Estoque estoque;
	
	@ManyToOne
	@JoinColumn(name="PEDIDO_ID", nullable=false)
	private Pedido pedido;
	
	@Column(name="QUANTIDADE", nullable=false)
	private short quantidade;
	
	@Column(name="ESTADO", nullable=false)
	private char estado;
	
	@Column(name="PRECO_UNITARIO", nullable=false, precision=7, scale=2)
	private BigDecimal precoUnitario;
	
	@Column(name="PRECO_TOTAL", nullable=false, precision=7, scale=2)
	private BigDecimal precoTotal;

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(short quantidade) {
		this.quantidade = quantidade;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}
	
}
