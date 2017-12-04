package br.iss.ecommerce.dao;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.iss.ecommerce.domain.Endereco;
import br.iss.ecommerce.domain.Parametro;
import br.iss.ecommerce.util.HibernateUtil;

public class ParametroDAO extends GenericDAO<Parametro> {
	public Parametro getFirstOrCreate()	
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try	
		{
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Parametro> query = builder.createQuery(currentClass);
			Root<Parametro> root = query.from(currentClass);  
			query.select(root);
			Parametro result = session.createQuery(query).getSingleResult();
			
			if (result == null)
			{
				result = new Parametro();
				result.setRemetente(new Endereco());
			}
			
			return result;
		} catch(NoResultException error) 
		{
			return null;
		} catch(RuntimeException error)	
		{
			throw error;
		} finally	{
			session.close();
		}		
	}
}
