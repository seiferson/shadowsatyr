package com.seifernet.shadowsatyr.persistance;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Session factory manager creates and configurates
 * the session factory object
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public abstract class SessionFactoryManager {

	private static SessionFactory instance;
	
	/**
	 * Session factory singleton, to avoid multiple factory
	 * instantiation.
	 * 
	 * @return The session factory object
	 */
	public static SessionFactory getSessionFactoryInstance( ){
		
		if( instance == null ){
			initializeSessionFactory( );
		}
		return instance;
	}
	
	/**
	 * Session factory configuration
	 * 
	 * TODO Make configuration programatic instead of using
	 * hibernate.cfg.xml
	 */
	private static void initializeSessionFactory(  ){
		Configuration 					configuration 	= null;
		StandardServiceRegistryBuilder 	builder 		= null;
		
		configuration = new Configuration( );
		configuration.configure( );
		builder = new StandardServiceRegistryBuilder( );
		builder.applySettings( configuration.getProperties(  ) );
		instance = configuration.buildSessionFactory( builder.build( ) );
	}
	
}
