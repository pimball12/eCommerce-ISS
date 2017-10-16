package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;

import br.iss.ecommerce.dao.GradeDAO;
import br.iss.ecommerce.dao.ParametroDAO;
import br.iss.ecommerce.domain.Grade;
import br.iss.ecommerce.domain.Parametro;
import br.iss.ecommerce.util.HibernateUtil;

@WebServlet("/adm/parametro")
public class Parametro_Index extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Parametro_Index() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		request.setAttribute("page_title", 			"Parametros");
		request.setAttribute("page_description", 	"Parametros gerais do sistema.");		
		
		ParametroDAO parametroDAO = new ParametroDAO();
		Parametro parametro = parametroDAO.getFirstOrDefault();

		request.setAttribute("parametro", parametro);
		request.getRequestDispatcher("/view/admin/parametro_index.jsp").forward(request, response);

		HibernateUtil.getSessionFactory().getCurrentSession().close();
	}

}
