package com.seifernet.shadowsatyr.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.persistence.DatabaseTest;
import com.seifernet.shadowsatyr.persistence.SessionFactoryManager;
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
		
		logger.info( "Deploying system, starting system configuration" );
		logger.info( "Testing default database connection: " + Definitions.SHADOW_SATYR_DEFAULT_DATASOURCE );
		if( !DatabaseTest.testDatabase( Definitions.SHADOW_SATYR_DEFAULT_DATASOURCE ) ){
			logger.info( "Database not available, skipping database validation/configuration");
			event.getServletContext( ).setAttribute( Definitions.DATABASE_TEST_RESULT_PARAM_NAME, false );
		} else {
			logger.info( "Success datasource testing" );
			event.getServletContext( ).setAttribute( Definitions.DATABASE_TEST_RESULT_PARAM_NAME, true );
			SessionFactoryManager.initializeSessionFactory(  );
			
			logger.info( "Initializing system constants" );
			AccountManager.init( );
		}
	}

}
