package com.seifernet.shadowsatyr.dispatcher;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.util.Definitions;
import com.seifernet.snwf.helper.DispatcherHelper;
import com.seifernet.snwf.util.SNWFDefinitions;

public class Dispatcher implements DispatcherHelper{

	private Logger logger = Logger.getLogger( Dispatcher.class );
	private int responseType;
	
	/**
	 * Constructor sets responseType to HTTP_RESPONSE
	 * by default
	 */
	public Dispatcher(  ){
		responseType = SNWFDefinitions.HTTP_RESPONSE;
	}
	
	@Override
	public String dispatchAction( HttpServletRequest request, HttpServletResponse response, String action ) {
		
		try{ 
			request.setCharacterEncoding( "UTF-8" );
		} catch( UnsupportedEncodingException e ){
			logger.error( Definitions.LOGGER_ERROR_1 );
		}
		
		switch( action ){
		
		}
		return SNWFDefinitions.TILES_REDIRECT_URL;
	}

	@Override
	public int getResponseType( ) {
		return responseType;
	}

}