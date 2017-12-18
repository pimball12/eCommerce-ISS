package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order_Create
 */
@WebServlet("/order/create")
public class Order_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Order_Create() {
        
    	super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute("cart");
		
		response.sendRedirect((String)request.getAttribute("base_url"));
	}

}
