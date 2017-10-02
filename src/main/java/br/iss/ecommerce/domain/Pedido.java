package br.iss.ecommerce.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@SuppressWarnings("serial")
@Entity
@Table(name="PEDIDO")
public class Pedido extends GenericDomain {

	@OneToOne
	@JoinColumn(name="TRANSACAO_ID")
	private Transacao transacao;
	
	@OneToOne
	@JoinColumn(name="USUARIO_ID", nullable=false)
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="ENDERECO_ID", nullable=false)
	private Endereco endereco;
	
	@Column(name="ESTADO", nullable=false)
	private char estado;
	
	@Column(name="PRECO_ITENS", nullable=false, precision=7, scale=2)
	private BigDecimal precoItens;
	
	@Column(name="PRECO_FRETE", nullable=false, precision=7, scale=2)
	private BigDecimal precoFrete;
	
	@Column(name="PRECO_TOTAL", nullable=false, precision=7, scale=2)
	private BigDecimal precoTotal;
	
	@Column(name="DATA", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date data;
	
	@Column(name="CODIGO_RASTREAMENTO", length=25)
	private String codigoRastreamento;
	
	@OneToMany(mappedBy="pedido")
	private Set<ItemPedido> itensPedido;

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public BigDecimal getPrecoItens() {
		return precoItens;
	}

	public void setPrecoItens(BigDecimal precoItens) {
		this.precoItens = precoItens;
	}

	public BigDecimal getPrecoFrete() {
		return precoFrete;
	}

	public void setPrecoFrete(BigDecimal precoFrete) {
		this.precoFrete = precoFrete;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCodigoRastreamento() {
		return codigoRastreamento;
	}

	public void setCodigoRastreamento(String codigoRastreamento) {
		this.codigoRastreamento = codigoRastreamento;
	}

	public Set<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(Set<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
}
