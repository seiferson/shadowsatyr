package com.seifernet.shadowsatyr.persistance;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.persistance.dto.Article;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;
import com.seifernet.shadowsatyr.persistance.dto.SystemProperty;

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
	 */
	private static void initializeSessionFactory(  ){
		Configuration 		configuration 	= null;
		Properties			properties		= null;
		ServiceRegistry		builder 		= null;
		
		configuration = new Configuration( );
		properties = new Properties( );
		
		properties.setProperty( "hibernate.connection.datasource" , "java:jboss/datasources/shadowsatyr" );
		properties.setProperty( "hibernate.dialect" , "org.hibernate.dialect.PostgreSQLDialect" );
		properties.setProperty( "hibernate.hbm2ddl.auto" , "create-drop" );
		properties.setProperty( "hibernate.current_session_context_class", "thread" );
		 
		configuration.addAnnotatedClass( Account.class );
		configuration.addAnnotatedClass( Article.class );
		configuration.addAnnotatedClass( BlogEntry.class );
		configuration.addAnnotatedClass( SystemProperty.class );
		
		configuration.setProperties( properties );
		builder = new StandardServiceRegistryBuilder( ).applySettings( configuration.getProperties(  ) ).build( );
		instance = configuration.buildSessionFactory( builder );
	}
	
}
