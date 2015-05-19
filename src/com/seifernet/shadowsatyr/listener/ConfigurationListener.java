package com.seifernet.shadowsatyr.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.persistance.SessionFactoryManager;
import com.seifernet.shadowsatyr.util.DatabaseTest;
import com.seifernet.shadowsatyr.util.Definitions;

/**
 * Servlet context listener used for
 * initialization in the app.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@WebListener
public class ConfigurationListener implements ServletContextListener{

	private Logger logger = Logger.getLogger( ConfigurationListener.class );
	
	@Override
	public void contextDestroyed( ServletContextEvent event ) {
		//Nothing to do
	}

	@Override
	public void contextInitialized( ServletContextEvent event ) {
		
		logger.debug( Definitions.LOGGER_DEBUG_1 );
		
		logger.debug( Definitions.LOGGER_DEBUG_2 + Definitions.SHADOW_SATYR_DEFAULT_DATASOURCE );
		if( !DatabaseTest.testDatabase( Definitions.SHADOW_SATYR_DEFAULT_DATASOURCE ) ){
			logger.debug( Definitions.LOGGER_DEBUG_3 );
		} else {
			logger.debug( "" );
			SessionFactoryManager.initializeSessionFactory( );
		}
		
		
		System.out.println( System.getProperty("jboss.server.log.dir") );
	}

}
