package br.iss.ecommerce.util;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void conectar() {
		
		Session session = HibernateUtil.getSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
	
}
