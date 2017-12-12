package br.iss.ecommerce.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import br.iss.ecommerce.domain.ItemGrade;
import br.iss.ecommerce.domain.Produto;
import br.iss.ecommerce.util.HibernateUtil;

public class ItemGradeDAO extends GenericDAO<ItemGrade> {

	public List<ItemGrade> listByEstoque(long estoque_id)	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<ItemGrade> itensGrade = session.createNativeQuery(
					"select ig.*  " +
					"from item_grade ig  " +
					"inner join estoque_item_grade eig on eig.ITEM_GRADE_ID = ig.ID " +
					"inner join estoque e on eig.ESTOQUE_ID = e.ID " +
					"where e.ID = :estoque_id " +
					"order by ig.GRADE_ID " 			
			)
			.addEntity(currentClass)
			.setParameter("estoque_id", estoque_id)
			.list();

			if (!itensGrade.isEmpty())
				return itensGrade;
			else
				return null;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} 		
	}
}
