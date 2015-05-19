package com.seifernet.shadowsatyr.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

public class DatabaseTest {
	
	private static Logger logger = Logger.getLogger( DatabaseTest.class );
	
	public static boolean testDatabase( String datasourceContext ) {
		Context 	context = null;
		DataSource	datasource = null;
		Connection	connection = null;
		
		try {
			context = new InitialContext( );
			datasource = ( DataSource ) context.lookup( datasourceContext );
			connection = datasource.getConnection( );
			
			connection.close( );
		} catch( NamingException e ){
			logger.error( Definitions.LOGGER_ERROR_9 );
			return false;
		} catch ( SQLException e ) {
			logger.error( Definitions.LOGGER_ERROR_9 );
			return false;
		}
		
		return true;
	}
	
}
