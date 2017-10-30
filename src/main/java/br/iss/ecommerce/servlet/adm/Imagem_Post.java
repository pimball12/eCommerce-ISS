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


@WebServlet("/adm/imagem/post")
@MultipartConfig
public class Imagem_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String SAVE_DIR = "D:\\JavaRes\\Ecommerce\\image";

	public Imagem_Post() {
        
		super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part filePart = request.getPart("imagem"); 
	    String oldName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    String fileName = createNewFileName(oldName);
	     
	    File uploads = new File(SAVE_DIR);
	    File file =    new File(uploads, fileName);
	    
	    try(InputStream fileContent = filePart.getInputStream())	{
	    	
	    	Files.copy(fileContent, file.toPath());
	    }
	    
	    // TODO: Inserir o nome da imagem no banco associado ao produto e redirecionar para a página de imagens.
	    
	    response.getWriter().append(fileName);	    
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
