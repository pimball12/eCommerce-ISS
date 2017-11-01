package br.iss.ecommerce.servlet.adm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ImagemDAO;
import br.iss.ecommerce.domain.Imagem;


@WebServlet("/adm/imagem/delete")
public class Imagem_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Imagem_Delete() {
        
    	super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupera o id.
		long id = Long.parseLong(request.getParameter("id").trim());
		
		// Cria as classes DAO.
		ImagemDAO imagemDAO = new ImagemDAO();
		
		// Encontra o item correspondente no banco.
		Imagem imagem = imagemDAO.find(id);
		
		// Recupera a pasta aonde é salvo os arquivos.
		String saveDir =  getServletContext().getInitParameter("upload.location");
		
		// Armazena o id do produto da imagem, e o caminho dela, além de recuperar a pasta de armazenamento.
		long produto_id = imagem.getProduto().getId();
		String caminho 	= imagem.getCaminho();
		
		// Exclúi a imagem do banco.
		imagemDAO.delete(imagem);
		
		// Exclúi a imagem da pasta.
		try {
			
			File file = new File(saveDir + File.separator + caminho);
			file.delete();
		} catch (Exception e) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		// Seta a mensagem de sucesso.
		request.getSession().setAttribute("flash_message_text", "Imagem excluída com sucesso.");
		request.getSession().setAttribute("flash_message_kind", "success");
		
		// Redireciona para a lista de produtos.
		response.sendRedirect(request.getAttribute("base_url") + "/adm/produto/edit?id=" + produto_id + "&tab=1");  	
	}

}
