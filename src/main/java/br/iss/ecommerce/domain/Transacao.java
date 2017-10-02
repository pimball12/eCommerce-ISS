package br.iss.ecommerce.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@SuppressWarnings("serial")
@Entity
@Table(name="TRANSACAO")
public class Transacao extends GenericDomain {

	@Column(name="TIPO_TRANSACAO", nullable=false)
	private char tipoTransacao;
	
	@Column(name="VALOR", nullable=false, precision=7, scale=2)
	private BigDecimal valor;
	
	@Column(name="ESTADO", nullable=false)
	private char estado;
	
	@Column(name="DATA_PAGAMENTO", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPagamento;
	
	@Column(name="DATA_CRIACAO", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date dataCriacao;

	public char getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(char tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}	
	
}
