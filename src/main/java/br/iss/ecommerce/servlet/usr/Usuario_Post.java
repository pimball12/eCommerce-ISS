package br.iss.ecommerce.servlet.usr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.iss.ecommerce.domain.Usuario;
import br.iss.ecommerce.domain.Pessoa;
import br.iss.ecommerce.domain.Endereco;
import br.iss.ecommerce.dao.UsuarioDAO;

@WebServlet("/user/post")
public class Usuario_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Usuario_Post() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// // Cria os objetos DAO.
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		// Define os objetos de Persistência.
		Usuario usuario;
		
		// Recupera as propriedades da grade.
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
		
		// Passa os outros atributos. 
		usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipo('C');
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setSobrenome(sobrenome);
		pessoa.setCpf(cpf);
		pessoa.setTelefone(telefone);
		
		Endereco endereco = new Endereco();
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setEstado(estado);
		endereco.setNumero(numero);
		endereco.setPais("Brasil");
		endereco.setRua(rua);
		
		pessoa.setEnderecoPrincial(endereco);
		usuario.setPessoa(pessoa);
		
		// Salva o item e seta a mensagem de sucesso.
		usuarioDAO.save(usuario);
		request.getSession().setAttribute("flash_message_text", "usuario adicionada com sucesso.");
			
		// Seta o tipo de mensagem como de sucesso e redireciona para a tela de edição daquela grade.
		request.getSession().setAttribute("flash_message_kind", "success");
		response.sendRedirect(	request.getAttribute("base_url") + 
								"/user/usuario_form.jsp");  		
	}

}
