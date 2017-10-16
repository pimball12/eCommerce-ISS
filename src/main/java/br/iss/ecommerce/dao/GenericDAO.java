package br.iss.ecommerce.dao;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
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
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
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
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Entity> query = builder.createQuery(currentClass);
			Root<Entity> root = query.from(currentClass);
			List<Entity> result = 	session.createQuery(query.select(root)
											.orderBy(builder.asc(root.get("id")))).getResultList();
			return result;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} 
	}
	
	public Entity find(Long id)	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Entity> query = builder.createQuery(currentClass);
			Root<Entity> root = query.from(currentClass);  
			query.select(root);
			query.where(builder.equal(root.get("id"), id));
			Entity result = session.createQuery(query).getSingleResult();
			return result;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} 
	}
	
	public void delete(Entity entity)	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
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
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
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
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
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
	
	public Long lastInsertId()	{
		
		HibernateUtil.closeLastSession();
		Session session = HibernateUtil.getSession();
		
		try	{
			
			Long id = ((BigInteger)session.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).longValue();
			return id;
		} catch(NoResultException error)	{
			
			return null;
		} catch(RuntimeException error)	{
			
			throw error;
		} 
	}
	
}
