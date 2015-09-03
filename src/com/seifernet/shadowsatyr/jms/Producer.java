package com.seifernet.shadowsatyr.jms;

import javax.jms.JMSException;
import javax.jms.QueueSender;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

public class Producer {

	private static Logger logger = Logger.getLogger( Producer.class );
	
	public static void sendMessage( String message ){
		try {
			QueueSender sender = QueueManager.getJMSSession( ).createSender( QueueManager.getJMSQueue( ) );
			TextMessage textMessage = QueueManager.getJMSSession( ).createTextMessage( message );
			sender.send( textMessage );
			
		} catch ( JMSException e ) {
			logger.error( "Cannot send JMS text message" );
		}
	}
}
