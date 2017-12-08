package br.iss.ecommerce.servlet.adm;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.EstoqueDAO;
import br.iss.ecommerce.dao.ItemGradeDAO;
import br.iss.ecommerce.dao.ProdutoDAO;
import br.iss.ecommerce.domain.Estoque;
import br.iss.ecommerce.domain.ItemGrade;
import br.iss.ecommerce.domain.Produto;

@WebServlet("/adm/estoque/insert")
public class Estoque_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Estoque_Insert() {
        
    	super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// Cria os objetos DAO.
			ProdutoDAO produtoDAO 		= new ProdutoDAO();
			EstoqueDAO estoqueDAO 		= new EstoqueDAO();
			ItemGradeDAO itemGradeDAO 	= new ItemGradeDAO();
			
			// Define os objetos de Persistência;
			Produto produto;
			Set<ItemGrade> itensGrade = new HashSet<ItemGrade>();
			Estoque estoque;
			
			// Recupera os parâmetros.
			long 		produto_id 			= Long.parseLong(request.getParameter("produto_id").trim());
			String[] 	itensGradeId		= request.getParameterValues("itensGrade");		
			short 		quantidade			= Short.parseShort(request.getParameter("quantidade").trim());
			BigDecimal 	peso				= new BigDecimal(request.getParameter("peso").trim().replace(',', '.')); 
			Date		data				= new Date();
			
			// Recupera o produto em questão.
			produto = produtoDAO.find(produto_id);
			
			// Recupera os itens de grade que devem ser associados ao estoque.
			for (String itemGrade_id : itensGradeId) 
				itensGrade.add(itemGradeDAO.find(Long.parseLong(itemGrade_id.trim())));
			
			estoque = estoqueDAO.findByItensGrade(itensGrade, produto_id);
			
			if (estoque != null)	{
				
				// Caso haja estoque com os itens de grade passados, atualizar quantidade.
				estoque.setQuantidade((short) (estoque.getQuantidade() + quantidade));
				estoqueDAO.update(estoque);
			} else {
				
				// Caso não haja, criar novo estoque.
				estoque = new Estoque();
				estoque.setItensGrade(itensGrade);
				estoque.setPeso(peso);
				estoque.setProduto(produto);
				estoque.setQuantidade(quantidade);
				estoque.setReservado((short)0);
				estoqueDAO.save(estoque);				
			}
			
			// Seta mensagem e volta para a tela de estoques do produto.
			request.getSession().setAttribute("flash_message_text", "Estoque alterado com sucesso.");
			request.getSession().setAttribute("flash_message_kind", "success");
			response.sendRedirect(	request.getAttribute("base_url") + 
					"/adm/produto/edit?id=" + produto_id + "&tab=2");
		} catch (Exception e) {
		
			// TODO: handle exception
		}
	}

}
