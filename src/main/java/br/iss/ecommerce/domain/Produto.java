package br.iss.ecommerce.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
	
	@Column(name="PESO_PADRAO", nullable=false, precision=7, scale=3)
	private BigDecimal pesoPadrao;
	
	@OneToMany(mappedBy="produto")
	@OrderBy("id")
	private Set<Estoque> estoques;
	
	@OneToMany(mappedBy="produto")
	@OrderBy("posicao")
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
	
	public List<Estoque> getEstoquesOrdered()	{
		
		List<Estoque> estoques = new ArrayList<Estoque>(getEstoques());
		
		Collections.sort(estoques, new Comparator<Estoque>() {

			@Override
			public int compare(Estoque e1, Estoque e2) {
				
				Object[] itens1 = e1.getItensGrade().toArray();
				String text1 = "";
				for(int i = 0; i < itens1.length; i++)	{
					text1 += ((ItemGrade)itens1[i]).getGrade().getNome();
					text1 += ((ItemGrade)itens1[i]).getValor();
				}
				
				Object[] itens2 = e2.getItensGrade().toArray();
				String text2 = "";
				for(int i = 0; i < itens2.length; i++)	{
					text2 += ((ItemGrade)itens2[i]).getGrade().getNome();
					text2 += ((ItemGrade)itens2[i]).getValor();
				}				
				
				return text1.compareTo(text2);
			}
		});		
		
		return estoques;
	}
	
}
