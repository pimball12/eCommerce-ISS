package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.EstoqueDAO;
import br.iss.ecommerce.dao.ImagemDAO;
import br.iss.ecommerce.domain.Estoque;


@WebServlet("/produto/add")
public class Produto_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Produto_Add() {
       
    	super();
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Define classes Dao.
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		
		// Recupera o id do estoque e encontra ele.
		long id = Long.parseLong(request.getParameter("estoque_id").trim());
		Estoque estoque = estoqueDAO.find(id);
		
		// Adiciona o item de estoque no carrinho.
		@SuppressWarnings("unchecked")
		List<Estoque> cart = ((LinkedList<Estoque>) request.getSession().getAttribute("cart"));
		cart.add(estoque);
		
		// Chama view.
		response.sendRedirect(request.getAttribute("base_url") + "/cart"); 
	}

}
