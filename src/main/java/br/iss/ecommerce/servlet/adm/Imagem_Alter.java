package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ImagemDAO;
import br.iss.ecommerce.domain.Imagem;


@WebServlet("/adm/imagem/alter")
public class Imagem_Alter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public Imagem_Alter() {
    
		super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Cria os objetos DAO.
		ImagemDAO imagemDAO = new ImagemDAO();
		
		// Define os objetos de persistência.
		Imagem imagem;
		
		// Recupera as propriedades da imagem.
		long id			= Long.parseLong(request.getParameter("id").trim());
		short posicao 	= Short.parseShort(request.getParameter("posicao").trim());
		
		// Encontra a imagem e faz a alteração da posição.
		imagem = imagemDAO.find(id);
		imagem.setPosicao(posicao);
		imagemDAO.update(imagem);
		
		// Recupera o id do produto da imagem.
		long produto_id		= imagem.getProduto().getId();
		
		// Redireciona para o produto.
		response.sendRedirect(request.getAttribute("base_url") + 
								"/adm/produto/edit?id=" + produto_id + "&tab=1"); 
	}

}
