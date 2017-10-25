package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.Grupo;
import br.iss.ecommerce.domain.Produto;


@WebServlet("/adm/produto/post")
public class Produto_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Produto_Post() {
        
    	super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Cria os objetos DAO.
		ProdutoDAO produtoDAO 	= new ProdutoDAO();
		GrupoDAO grupoDAO 		= new GrupoDAO();
		
		// Define os objetos de Persistência.
		Produto produto;
		
		// Recupera as propriedades do produto.
		long 		id 			= Long.parseLong(request.getParameter("id").trim());
		String 		nome		= request.getParameter("produto_nome");
		String 		descricao 	= request.getParameter("produto_descricao");
		BigDecimal	preco		= new BigDecimal(request.getParameter("produto_preco").trim().replace(',', '.'));
		BigDecimal	pesoPadrao	= new BigDecimal(request.getParameter("produto_pesoPadrao").trim().replace(',', '.'));
		Grupo 		grupo		= grupoDAO.find(Long.parseLong(request.getParameter("grupo_id").trim()));
		Boolean		ativo		= (request.getParameter("produto_ativo") != null);
		Boolean		destaque	= (request.getParameter("produto_destaque") != null);
		
		// Verifica se é inserção ou atualização.
		if (id == 0)			
			produto = new Produto();
		else 			
			produto = produtoDAO.find(id);		
		
		// Passa os outros atributos. 
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setPreco(preco);
		produto.setPesoPadrao(pesoPadrao);
		produto.setGrupo(grupo);
		produto.setAtivo(ativo);
		produto.setDestaque(destaque);
		
		
		// Salva o item e seta a mensagem de sucesso.
		if (id == 0)	{	
			produtoDAO.save(produto);
			request.getSession().setAttribute("flash_message_text", "Produto adicionado com sucesso.");
		} else {
			produtoDAO.update(produto);
			request.getSession().setAttribute("flash_message_text", "Produto editado com sucesso.");
		}
			
		// Seta o tipo de mensagem como de sucesso e redireciona para a tela de edição daquela produto.
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/adm/produto/edit?id=" + produto.getId());   			
	}

}
