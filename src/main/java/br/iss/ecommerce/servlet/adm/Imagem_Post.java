package br.iss.ecommerce.servlet.adm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.iss.ecommerce.dao.ImagemDAO;
import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Imagem;
import br.iss.ecommerce.domain.Produto;


@WebServlet("/adm/imagem/post")
@MultipartConfig
public class Imagem_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public Imagem_Post() {
        
		super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Inclúi as classes DAO necessárias.
		ProdutoDAO produtoDAO 	= new ProdutoDAO(); 
		ImagemDAO imagemDAO 	= new ImagemDAO();	
		
		// Define os objetos de persistencia.
		Produto produto;
		Imagem imagem;
		
		// Recupera o id do produto.
		long produto_id 		= Long.parseLong(request.getParameter("produto_id").trim());
		
		// Recupera o diretório para salvar as imagens.
		String saveDir = getServletContext().getInitParameter("upload.location");
		
		// Salva o arquivo na pasta denominada SAVE_DIR, e guarda o nome da imagem.
		Part filePart = request.getPart("imagem"); 
	    String oldName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    String fileName = createNewFileName(oldName);
	     
	    File uploads = new File(saveDir);
	    File file =    new File(uploads, fileName);
	    
	    try(InputStream fileContent = filePart.getInputStream())	{
	    	
	    	Files.copy(fileContent, file.toPath());
	    }
	    
	    // TODO: Inserir o nome da imagem no banco associado ao produto e redirecionar para a página de imagens.
	    produto = produtoDAO.find(produto_id);
	    imagem = new Imagem();
	    imagem.setProduto(produto);
	    imagem.setCaminho(fileName);
	    imagem.setPosicao((short) 0);
	    imagemDAO.save(imagem);
	    
	    // Seta a mensagem de sucesso e redireciona para a página do produto.
	    request.getSession().setAttribute("flash_message_text", "Imagem associada com sucesso.");
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/adm/produto/edit?id=" + produto_id + "&tab=1");  		
	}
	
	private String createNewFileName(String oldName)	{
		
		String extension = "";
		int i = oldName.lastIndexOf('.');
		if (i > 0) {
		    extension = oldName.substring(i+1);
		}
		
		String name = new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + "." + extension;
		
		return name;
	}

}
