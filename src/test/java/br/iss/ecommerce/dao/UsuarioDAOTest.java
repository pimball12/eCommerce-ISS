package br.iss.ecommerce.dao;

import org.junit.Test;
import org.junit.Assert;

import br.iss.ecommerce.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	public void deve_retornar_usuario_existente()	{
		
		String login = "meuteste1@email.com";
		String senha = "minhasenha";
		Usuario usuario = new Usuario();
		
		usuario.setEmail(login);
		usuario.setSenha(senha);
		usuario.setTipo('C');
		usuario.setPessoa(null);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.save(usuario);
		
		Usuario result = usuarioDAO.tryLogin(login, senha);
		
		Assert.assertEquals(usuario.getEmail(), result.getEmail());
		Assert.assertEquals(usuario.getSenha(), result.getSenha());
		Assert.assertEquals(usuario.getTipo(), result.getTipo());
		
		usuarioDAO.delete(usuario);
	}

	@Test
	public void deve_retornar_null_usuario_nao_existe()	{
		
		String login = "meuteste1@email.com";
		String senha = "minhasenha";
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario result = usuarioDAO.tryLogin(login, senha);
		
		Assert.assertNull(result);
	}
	
	
	@Test
	public void deve_retornar_null_usuario_senha_incorreta()	{
		
		String login = "meuteste1@email.com";
		String senha = "minhasenha";
		String senha2 = "notminhasenha";
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(login);
		usuario.setSenha(senha);
		usuario.setTipo('C');
		usuario.setPessoa(null);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.save(usuario);
		
		Usuario result = usuarioDAO.tryLogin(login, senha2);
		
		Assert.assertNull(result);
		
		usuarioDAO.delete(usuario);
	}
	
	@Test
	public void deve_retornar_null_usuario_login_incorreta()	{
		
		String login = "meuteste1@email.com";
		String senha = "minhasenha";
		String login2 = "notmeuteste1@email.com";
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail(login);
		usuario.setSenha(senha);
		usuario.setTipo('C');
		usuario.setPessoa(null);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.save(usuario);
		
		Usuario result = usuarioDAO.tryLogin(login2, senha);
		
		Assert.assertNull(result);
		
		usuarioDAO.delete(usuario);
	}
}
