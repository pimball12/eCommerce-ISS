package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.GrupoDAO;
import br.iss.ecommerce.domain.Grupo;
import br.iss.ecommerce.domain.Produto;


@WebServlet("/adm/produto/create")
public class Produto_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Produto_Create() {
        
    	super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Passa as informações básicas da página.
		request.setAttribute("page_title", 				"Produtos");
		request.setAttribute("page_description", 		"Novo Produto.");
		
		// Cria os objetos DAO necessários.
		GrupoDAO grupoDAO = new GrupoDAO();
		
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
		
		// Cria um produto vazio.
		Produto produto = new Produto();
		produto.setAtivo(true);
		
		// Recupera os grupos existentes.
		List<Grupo> grupos = grupoDAO.list();
		
		// Passa os dados para a view.
		request.setAttribute("produto", produto);
		request.setAttribute("grupos", grupos);
		
		// Chama a view.
		request.getRequestDispatcher("/view/admin/produto_form.jsp").forward(request, response);
	}

}
