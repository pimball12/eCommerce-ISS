package br.iss.ecommerce.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.iss.ecommerce.domain.Endereco;
import br.iss.ecommerce.util.HibernateUtil;

public class EnderecoDAO extends GenericDAO<Endereco> {

	public Endereco getByPessoa(long pessoa_id)	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Endereco> query = builder.createQuery(currentClass);
			Root<Endereco> root = query.from(currentClass);
			query.select(root);
			query.where(builder.equal(root.get("pessoa"), pessoa_id));
			List<Endereco> result = 	session.createQuery(query.select(root)).getResultList();
			
			return !result.isEmpty() ? result.get(0) : null;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} 		
	}	
	
}
