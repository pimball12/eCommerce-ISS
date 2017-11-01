package br.iss.ecommerce.servlet.adm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adm/imagem/get")
public class Imagem_Get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final int DEFAULT_BUFFER_SIZE = 1024 * 1024 * 10; // 10MB

    public Imagem_Get() {
        
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Recupera o nome da imagem.
		String path = request.getParameter("path").trim();
		
		// Recupera o diretório de salvar as imagens.
		String save_dir = getServletContext().getInitParameter("upload.location");
		
		// Cria o objeto do arquivo.
		File file = new File(save_dir + File.separator + path);
		
		// Checa se o arquivo existe, e lança um erro do contrário.
		if (!file.exists())	{
			
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		// Pega o tipo do arquivo pelo seu nome. E caso contrário define um padrão.
		String contentType = getServletContext().getMimeType(file.getName());
		if (contentType == null)	{
			
			contentType = "application/octet-stream";
		}
		
		// Inicia a resposta.
		response.reset();
		response.setBufferSize(DEFAULT_BUFFER_SIZE);
		response.setContentType(contentType);
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
		
		// Define Streams.
		BufferedInputStream input 	= null;
		BufferedOutputStream output = null;
		
		try {
			
			// Abre streams.
			input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
			output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
			
			// Escreve o conteúdo na resposta da requisição.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0)	{
				
				output.write(buffer, 0, length);
			}
		} finally {
			
			// Fecha as streams.
			output.close();
			input.close();
			
		}
	}

}
