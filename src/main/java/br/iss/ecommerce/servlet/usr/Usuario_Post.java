package br.iss.ecommerce.servlet.usr;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.dao.EnderecoDAO;
import br.iss.ecommerce.dao.PessoaDAO;
import br.iss.ecommerce.dao.UsuarioDAO;
import br.iss.ecommerce.domain.Endereco;
import br.iss.ecommerce.domain.Pessoa;
import br.iss.ecommerce.domain.Usuario;

@WebServlet("/user/post")
public class Usuario_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Usuario_Post() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String 	nome        = request.getParameter("nome");
		String 	sobrenome   = request.getParameter("sobrenome");
		String 	cpf	        = request.getParameter("cpf");
		String 	telefone    = request.getParameter("cpf");
		String 	email       = request.getParameter("email");
		String 	senha       = request.getParameter("senha");
		String 	cep         = request.getParameter("cep");
		String 	cidade      = request.getParameter("cidade");
		String 	estado      = request.getParameter("estado");
		String 	rua         = request.getParameter("rua");
		String 	numero      = request.getParameter("numero");
		String 	complemento = request.getParameter("complemento");
		String 	bairro      = request.getParameter("bairro");
		
		// Seta objetos de persistencia.
		Endereco endereco	= new Endereco();
		Pessoa pessoa 		= new Pessoa();
		Usuario usuario = new Usuario();
		
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setNumero(numero);
		endereco.setPais("Brasil");
		endereco.setRua(rua);		
		endereco.setPessoa(null);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		enderecoDAO.save(endereco);
		
		pessoa.setNome(nome);
		pessoa.setSobrenome(sobrenome);
		pessoa.setCpf(cpf);
		pessoa.setTelefone(telefone);
		pessoa.setEnderecoPrincial(endereco);
		pessoa.setEnderecos(new HashSet<Endereco>());
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.save(pessoa);
		
		
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipo('C');		
		usuario.setPessoa(pessoa);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.save(usuario);
		
		request.getSession().setAttribute("flash_message_text", "usuario adicionada com sucesso.");
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(request.getAttribute("base_url") + "/user/login");  		
	}

}
