package br.iss.ecommerce.dao;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.iss.ecommerce.domain.Endereco;
import br.iss.ecommerce.domain.Parametro;
import br.iss.ecommerce.util.HibernateUtil;

public class ParametroDAO extends GenericDAO<Parametro> {
	public Parametro getFirstOrCreate()	
	{
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try		{
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Parametro> query = builder.createQuery(currentClass);
			Root<Parametro> root = query.from(currentClass);  
			query.select(root);
			Parametro parametro = session.createQuery(query).getSingleResult();
			
			return parametro;
		} catch(NoResultException error) 	{
			
			EnderecoDAO enderecoDAO = new EnderecoDAO();
			Endereco endereco = new Endereco();
			endereco.setBairro("");
			endereco.setCep("");
			endereco.setCidade("");
			endereco.setComplemento("");
			endereco.setEstado("");
			endereco.setNumero("");
			endereco.setPais("");
			endereco.setRua("");
			enderecoDAO.save(endereco);
			
			Parametro parametro = new Parametro();
			parametro.setEmail("");
			parametro.setRemetente(endereco);
			
			save(parametro);
			
			System.out.println(error.getMessage()); 
			
			return parametro;
		} catch(RuntimeException error)	
		{
			throw error;
		} finally	{
			session.close();
		}		
	}
}
