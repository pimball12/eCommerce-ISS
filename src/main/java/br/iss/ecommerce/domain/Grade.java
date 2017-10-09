package br.iss.ecommerce.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(name="GRADE")
public class Grade extends GenericDomain {

	@Column(name="NOME", length=50, nullable=false)
	private String nome;
	
	@OneToMany(mappedBy="grade", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<ItemGrade> itensGrade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<ItemGrade> getItensGrade() {
		return itensGrade;
	}

	public void setItensGrade(Set<ItemGrade> itensGrade) {
		this.itensGrade = itensGrade;
	}

	@Override
	public String toString() {
		return "Grade [nome=" + nome + "]";
	}
	
}
