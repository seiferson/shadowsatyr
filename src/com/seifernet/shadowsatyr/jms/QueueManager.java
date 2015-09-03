package com.seifernet.shadowsatyr.jms;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

public class QueueManager {
	
	private static Logger logger = Logger.getLogger( QueueManager.class );
	
	private static Queue queue;
	private static QueueSession session;
	
	public static Queue getJMSQueue(  ){
		if( queue == null ){
			try{ 
				InitialContext context = new InitialContext( );
				queue = ( Queue ) context.lookup( "queue/test" );
			} catch( NamingException e ){
				logger.error( "Error getting JMS queue from context" );
			}
		}
		return queue;
	}
	
	public static QueueSession getJMSSession( ){
		if( session == null ){
			try{
				InitialContext context = new InitialContext( );
				QueueConnectionFactory factory = ( QueueConnectionFactory ) context.lookup( "ConnectionFactory" );
				QueueConnection connection = factory.createQueueConnection( );
				session = connection.createQueueSession( false, QueueSession.AUTO_ACKNOWLEDGE );
				connection.start();
			} catch( JMSException e ){
				logger.error( "Error creating JMS objects" );
			} catch( NamingException e ){
				logger.error( "Error getting JMS session from context" );
			}
		}
		return session;
	}
}
