package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Estoque;

/**
 * Servlet implementation class Produto_Remove
 */
@WebServlet("/produto/remove")
public class Produto_Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Produto_Remove() {
        
    	super();
    }

    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Recupera o id do estoque e encontra ele.
		long id = Long.parseLong(request.getParameter("estoque_id").trim());
		
		// Remove o item de estoque no carrinho.
		List<Estoque> cart = ((LinkedList<Estoque>) request.getSession().getAttribute("cart"));
		for (int index = 0; index < cart.size(); index++) 
			if (Long.compare(cart.get(index).getId(), id) == 0)	{
				cart.remove(index);
				request.getSession().setAttribute("cart", (LinkedList<Estoque>)cart);
				break;
			}
		
		// Chama view.
		response.sendRedirect(request.getAttribute("base_url") + "/cart"); 		
	}

}
