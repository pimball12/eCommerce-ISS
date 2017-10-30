package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Grupo;
import br.iss.ecommerce.domain.Produto;


@WebServlet("/adm/produto/edit")
public class Produto_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Produto_Edit() {
        
    	super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// Passa as informações básicas da página.
			request.setAttribute("page_title", 				"Produtos");
			request.setAttribute("page_description", 		"Editar Produto.");	
			
			// Pega a tab ativa da página.
			int tab =  ((Object)request.getParameter("tab") != null) ? 
						Integer.parseInt(request.getParameter("tab").trim()) :
						0;
			
			// Instancia objetos DAO.
			ProdutoDAO produtoDAO 	= new ProdutoDAO();
			GrupoDAO   grupoDAO		= new GrupoDAO();
			
			// Passa os arquivos .js e .css necessários.
			String[] scripts = {
				"plugins/select2/select2.full.min.js", 
				"public/select2.js",
				"plugins/numeric/numeric.min.js",
				"public/numeric.js"
			};
			request.setAttribute("scripts", scripts);
			
			String[] styles = {"plugins/select2/select2.min.css"};
			request.setAttribute("styles", styles); 			
			
			// Pega o código da produto.
			long id = Long.parseLong(request.getParameter("id").trim());
			
			// Recupera o produto e os grupos.
			Produto produto = produtoDAO.find(id);
			List<Grupo> grupos = grupoDAO.list();
			
			// Passa os dados para a view.
			request.setAttribute("produto", produto);
			request.setAttribute("grupos", grupos);
			request.setAttribute("tab", tab);
			
			// Chama a View.
			request.getRequestDispatcher("/view/admin/produto_form.jsp").forward(request, response);					
		} catch (Exception e) {
			
			response.getWriter().append("Error: " + e.getMessage());
		}	
	}

}
