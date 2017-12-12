package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ParametroDAO;


@WebServlet("/contato")
public class Contato_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Contato_Index() {
        
    	super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Define objetos DAO.
		ParametroDAO parametroDAO = new ParametroDAO();
		
		// Define configurações da página.
		request.setAttribute("email", parametroDAO.getFirstOrCreate().getEmail()); 
		
		// Chama a view.
		request.getRequestDispatcher("/view/user/contato.jsp").forward(request, response);
	}

}
