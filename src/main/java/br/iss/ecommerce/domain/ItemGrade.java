package br.iss.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ITEM_GRADE")
public class ItemGrade extends GenericDomain {

	@Column(name="VALOR", length=50)
	private String valor;
	
	@ManyToOne
	@JoinColumn(name="GRADE_ID", nullable=false)
	private Grade grade;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}
