package br.iss.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@SuppressWarnings("serial")
@Entity
@Table(name="MENU_ESTATICO")
public class MenuEstatico extends GenericDomain {

	@Column(name="TITULO", length=20, nullable=false)
	private String titulo;
	
	@Column(name="POSICAO", nullable=false)
	private short posicao;
	
	@Column(name="CONTEUDO", nullable=false)
	@Type(type="text")
	private String conteudo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public short getPosicao() {
		return posicao;
	}

	public void setPosicao(short posicao) {
		this.posicao = posicao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
}
