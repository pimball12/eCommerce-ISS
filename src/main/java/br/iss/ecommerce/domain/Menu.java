package br.iss.ecommerce.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="MENU")
public class Menu extends GenericDomain {

	@Column(name="TITULO", length=50, nullable=false)
	private String titulo;
	
	@Column(name="POSICAO", nullable=false)
	private short posicao;
	
	@Column(name="MOSTRA_FILTROS", nullable=false)
	private Boolean mostraFiltros;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name = "MENU_GRUPO",  
		joinColumns = {
			@JoinColumn(name = "MENU_ID", nullable = false, updatable = false) 
		},
		inverseJoinColumns = { 
			@JoinColumn(name = "GRUPO_ID", nullable = false, updatable = false) 
		}
	)
	private Set<Grupo> grupos;

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

	public Boolean getMostraFiltros() {
		return mostraFiltros;
	}

	public void setMostraFiltros(Boolean mostraFiltros) {
		this.mostraFiltros = mostraFiltros;
	}

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}
	
}
