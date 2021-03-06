package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.ImagemDAO;
import br.iss.ecommerce.dao.ItemGradeDAO;
import br.iss.ecommerce.domain.Estoque;

/**
 * Servlet implementation class Cart_Index
 */
@WebServlet("/cart")
public class Cart_Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Cart_Index() {
        
    	super();
    }

    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Passa o carrinho para a chamada.
		request.setAttribute("cart", (LinkedList<Estoque>)request.getSession().getAttribute("cart"));
		
		// Passa o dao de imagem e estoque para a view.
		ImagemDAO imagemDAO = new ImagemDAO();
		ItemGradeDAO itemGradeDAO = new ItemGradeDAO();
		request.setAttribute("imagemDAO", imagemDAO);
		request.setAttribute("itemGradeDAO", itemGradeDAO);
		
		// Chama a view.
		request.getRequestDispatcher("/view/user/cart.jsp").forward(request, response);
	}

}
