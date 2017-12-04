package br.iss.ecommerce.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import br.iss.ecommerce.domain.Estoque;
import br.iss.ecommerce.domain.ItemGrade;
import br.iss.ecommerce.util.HibernateUtil;
import javassist.bytecode.SignatureAttribute.ArrayType;

public class EstoqueDAO extends GenericDAO<Estoque> {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Estoque findByItensGrade(Set<ItemGrade> itensGrade)	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{		
			
			// Verifica se o estoque tem Itens de Grade associados a ele.
			if (itensGrade.size() <= 0)	
				return null;
			
			// Define a variável de lista que recuperará o(s) estoque(s).
			List<Estoque> estoques = null;
				
			// Dados que serão passados para a query.
			// Lista em ids, o código dos itens de grade.
			int quant	= itensGrade.size();
			List<Long> ids = new ArrayList<Long>();
			for(ItemGrade itemGrade : itensGrade)	
				ids.add(itemGrade.getId());
			
			// Busca o estoque se ele existe.
			estoques = session.createNativeQuery(
					"select distinct e.* from estoque e " +
					"inner join estoque_item_grade eig on e.ID = eig.ESTOQUE_ID " +
					"where " +
					"	eig.ITEM_GRADE_ID not in (SELECT ig.ID from item_grade ig where ig.ID not in :ids) " +
					"and " +
					"	eig.ITEM_GRADE_ID in :ids " +
					"and " +
					"	(SELECT COUNT(*) from estoque_item_grade eig2  " +
					" 	where eig2.ESTOQUE_ID = e.ID and eig2.ITEM_GRADE_ID in :ids) = :quant "
			)
			.addEntity(currentClass)
			.setParameter("ids", ids)
			.setParameter("quant", quant)
			.list();
		
			// Retorna o estoque, se tiver.
			if (!estoques.isEmpty())
				return estoques.get(0);
			else
				return null;
					
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		}
	}
}
