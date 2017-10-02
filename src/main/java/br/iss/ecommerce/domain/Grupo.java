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
@Table(name="GRUPO")
public class Grupo extends GenericDomain {

	@Column(name="NOME", length=50, nullable=false)
	private String nome;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name = "GRUPO_GRADE",  
		joinColumns = {
			@JoinColumn(name = "GRUPO_ID", nullable = false, updatable = false) 
		},
		inverseJoinColumns = { 
			@JoinColumn(name = "GRADE_ID", nullable = false, updatable = false) 
		}
	)
	private Set<Grade> grades;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Grade> getGrades() {
		return grades;
	}

	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	
}
