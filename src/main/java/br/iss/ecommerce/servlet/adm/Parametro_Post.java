package br.iss.ecommerce.servlet.adm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.EnderecoDAO;
import br.iss.ecommerce.dao.ParametroDAO;
import br.iss.ecommerce.domain.Parametro;


@WebServlet("/adm/parametro/post")
public class Parametro_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Parametro_Post() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParametroDAO parametroDAO = new ParametroDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		Parametro parametro = parametroDAO.getFirstOrCreate();
		
		String email = request.getParameter("email");
		String estado = request.getParameter("estado");
		String pais = request.getParameter("pais");
//		String cidade = request.getParameter("cidade");
		
		parametro.getRemetente().setPais(pais);
		parametro.getRemetente().setEstado(estado);
//		parametro.getRemetente().setCidade(cidade);
		enderecoDAO.update(parametro.getRemetente());
		
		parametro.setEmail(email);		
		parametroDAO.update(parametro);
		
		request.getSession().setAttribute("flash_message_text", "Parametro salvo com sucesso.");
		response.sendRedirect(	request.getAttribute("base_url") + "/adm/parametro/edit"); 
	}
}