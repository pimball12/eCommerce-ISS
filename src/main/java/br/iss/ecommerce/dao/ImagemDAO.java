package br.iss.ecommerce.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.iss.ecommerce.domain.Imagem;
import br.iss.ecommerce.util.HibernateUtil;

public class ImagemDAO extends GenericDAO<Imagem> {

	public List<Imagem> listByProduto(long produto_id)	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Imagem> query = builder.createQuery(currentClass);
			Root<Imagem> root = query.from(currentClass);
			query.select(root);
			query.where(builder.equal(root.get("produto"), produto_id));
			List<Imagem> result = 	session.createQuery(query.select(root)
											.orderBy(builder.asc(root.get("posicao")))).getResultList();
			return result;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} 		
	}
}
