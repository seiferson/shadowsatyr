package com.seifernet.shadowsatyr.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

public class Consumer implements MessageListener{

	private Logger logger = Logger.getLogger( Consumer.class );
	
	public void onMessage( Message message ) {
		try {
			TextMessage textMessage = ( TextMessage )message;
			logger.info( "Received Message: " + textMessage.getText( ) );
		} catch ( JMSException e ) {
			logger.error( "Error obtaining message content" );
		}
	}
}
