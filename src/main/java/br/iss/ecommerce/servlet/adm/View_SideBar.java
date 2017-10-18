package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adm/view/sidebar")
public class View_SideBar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public View_SideBar() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean sidebar_collapse = (boolean)request.getSession().getAttribute("sidebar_collapse");
		
		if (sidebar_collapse == false)	{
			
			request.getSession().setAttribute("sidebar_collapse", true);
		} else {
			
			request.getSession().setAttribute("sidebar_collapse", false);
		}
		
		response.setContentType("text/plain");
	}

}
