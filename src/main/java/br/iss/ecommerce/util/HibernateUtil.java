package br.iss.ecommerce.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sf;
    
    private static StandardServiceRegistry registry;

    public static Session getSession() {
    	
        return getSessionFactory().openSession();
    }

    public static SessionFactory getSessionFactory() {
    	
        if ( sf == null ) {
            createSessionFactory();
        }
        
        return sf;
    }
    
    private static void createSessionFactory()	{
    	try {
    		
    		// Create registry.
    		registry = new StandardServiceRegistryBuilder()
    				.configure()
    				.build();
    		
    		// Create Metadata Sources.
    		MetadataSources sources = new MetadataSources(registry);
    		
    		// Create Metadata.
    		Metadata metadata = sources.getMetadataBuilder().build();
    		
    		sf = metadata.getSessionFactoryBuilder().build();
    		
		} catch (Throwable ex) {
			
			System.out.println("A fábrica de sessões não pode ser criada. :" + ex.getMessage());
			
			throw new ExceptionInInitializerError(ex);
		}
    }
}

