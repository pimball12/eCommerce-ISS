package br.iss.ecommerce.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import br.iss.ecommerce.domain.Produto;
import br.iss.ecommerce.util.HibernateUtil;

public class ProdutoDAO extends GenericDAO<Produto> {

	public List<Produto> listAvaiable()	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Produto> produtos = session.createNativeQuery(
					"select distinct p.*  " +
					"from produto p  " +
					"inner join estoque e on e.PRODUTO_ID = p.ID " +
					"where e.QUANTIDADE - e.RESERVADO > 0 " +
					"order by p.NOME " 			
			)
			.addEntity(currentClass)
			.list();

			if (!produtos.isEmpty())
				return produtos;
			else
				return null;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} 		
	}
}
