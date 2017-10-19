package br.iss.ecommerce.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.iss.ecommerce.domain.Grupo;
import br.iss.ecommerce.domain.Produto;

public class ProdutoDaoTest {
	
	@Test
	@Ignore
	public void save()	{
		
		ProdutoDAO produtoDAO 	= new ProdutoDAO();
		GrupoDAO grupoDAO		= new GrupoDAO();
		
		Produto produto 		= new Produto();
		Grupo	grupo			= grupoDAO.find(1L);
		
		produto.setNome(		"Caneta Multipoderosa Policromática");
		produto.setDescricao(	"Ferramenta para extraír lipídios do cosmos.");
		produto.setAtivo(		true);
		produto.setDestaque(	true);
		produto.setPreco(		new BigDecimal(1.61));
		produto.setPesoPadrao(	new BigDecimal(0.666));
		produto.setGrupo(  		grupo);
		
		produtoDAO.save(produto);
	}
}
