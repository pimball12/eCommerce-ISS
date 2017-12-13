package br.iss.ecommerce.dao;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import br.iss.ecommerce.domain.Usuario;
import br.iss.ecommerce.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{
	public boolean tryLogin(String login, String senha)	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Usuario> usuarios = session.createNativeQuery(
					"select * " +
					"  from usuario " +
					" where EMAIL = :login" +
					"   and SENHA = :senha" 			
			)
			.addEntity(currentClass)
			.setParameter("login", login)
			.setParameter("senha", senha)
			.list();
			
		    return !usuarios.isEmpty()  ;
		} catch(NoResultException error)	{
			
			return false;
		} catch(RuntimeException error)	{
			
			throw error;
		} 		
	}
}
