package br.iss.ecommerce.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.iss.ecommerce.util.HibernateUtil;

public class GenericDAO<Entity> {
	
	private Class<Entity> currentClass;
	
	@SuppressWarnings("unchecked")
	public GenericDAO()	{
		
		this.currentClass = (Class<Entity>)((ParameterizedType) 
							getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void save(Entity entity)	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try	{
			
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch(RuntimeException error)	{
			
			if (transaction != null) {
				
				transaction.rollback();
			}
			
			throw error;
		} finally	{
			
			session.close();
		}
	}
	
	public List<Entity> list()	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try	{
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Entity> query = builder.createQuery(currentClass);
			query.select(query.from(currentClass));
			List<Entity> result = session.createQuery(query).getResultList();
			return result;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} finally	{
			
			// Por estarmos utilizando FetchType.LAZY, as consultas são feitas em tempo
			// real quando chamamos as classes relacionadas. Assim, a sessão deve ser 
			// fechada apenas após a utilização dos itens da consulta. O mesmo se aplica
			// à find().
			//session.close();
		}
	}
	
	public Entity find(Long codigo)	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try	{
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Entity> query = builder.createQuery(currentClass);
			Root<Entity> root = query.from(currentClass);  
			query.select(root);
			query.where(builder.equal(root.get("codigo"), codigo));
			Entity result = session.createQuery(query).getSingleResult();
			return result;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} finally	{
			
//			session.close();
		}		
	}
	
	public void delete(Entity entity)	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try	{
			
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch(RuntimeException error)	{
			
			if (transaction != null) {
				
				transaction.rollback();
			}
			
			throw error;
		} finally	{
			
			session.close();
		}
	}	
	
	public void update(Entity entity)	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try	{
			
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
		} catch(RuntimeException error)	{
			
			if (transaction != null) {
				
				transaction.rollback();
			}
			
			throw error;
		} finally	{
			
			session.close();
		}
	}		
	
	public void merge(Entity entity)	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try	{
			
			transaction = session.beginTransaction();
			session.merge(entity);
			transaction.commit();
		} catch(RuntimeException error)	{
			
			if (transaction != null) {
				
				transaction.rollback();
			}
			
			throw error;
		} finally	{
			
			session.close();
		}
	}	
	
}
