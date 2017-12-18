package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.EnderecoDAO;
import br.iss.ecommerce.dao.ImagemDAO;
import br.iss.ecommerce.dao.ItemGradeDAO;
import br.iss.ecommerce.domain.Estoque;


@WebServlet("/cart/finish")
public class Cart_Finish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Cart_Finish() {
        
    	super();
    }


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getAttribute("user") == null)	{
			
			// Passa o usuário para a tela de login caso não haja usuário logado.
			response.sendRedirect(request.getAttribute("base_url") + "/user/login");
		} else {
			
			// Passa o carrinho para a chamada.
			request.setAttribute("cart", (LinkedList<Estoque>)request.getSession().getAttribute("cart"));
			
			// Passa o dao de imagem e estoque para a view.
			ImagemDAO imagemDAO = new ImagemDAO();
			ItemGradeDAO itemGradeDAO = new ItemGradeDAO();
			EnderecoDAO	enderecoDAO = new EnderecoDAO();
			request.setAttribute("imagemDAO", imagemDAO);
			request.setAttribute("itemGradeDAO", itemGradeDAO);		
			request.setAttribute("enderecoDAO", enderecoDAO);
			
			// Chama a view.
			request.getRequestDispatcher("/view/user/finish.jsp").forward(request, response);	
		}	
	}

}
