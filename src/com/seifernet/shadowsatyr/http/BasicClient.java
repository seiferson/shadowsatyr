package com.seifernet.shadowsatyr.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.util.Definitions;

/**
 * Basic http client
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class BasicClient {
	
	private static Logger logger = Logger.getLogger( BasicClient.class );
	private CloseableHttpClient client;
	
	/**
	 * Constructor that gets an instance of http client
	 */
	public BasicClient( ){
		client = HttpClients.createDefault( );
	}
	
	/**
	 * HTTP POST method
	 * 
	 * @param data The data to be sent
	 * @param headers Custom headers
	 * @param url Destination URL
	 * @return Response body as string
	 */
	public String doPost( HashMap<String, String> data, HashMap<String, String> headers, String url ){
		HttpPost 				post 		= null;
		List<NameValuePair> 	values 		= null;
		CloseableHttpResponse 	response 	= null;
		String					responseStr	= "";

		try{
			post = new HttpPost( url );
			
			if( headers != null ){
				for( Entry<String, String> element : headers.entrySet( ) ){
					post.setHeader( element.getKey( ) , element.getValue( ) );
				}
			}
			
			if( data != null ){
				values = new ArrayList<NameValuePair>( );
				
				for( Entry<String, String> element : data.entrySet( ) ){
					values.add( new BasicNameValuePair( element.getKey( ) , element.getValue( ) ) );
				}
				
				post.setEntity( new UrlEncodedFormEntity( values , Consts.UTF_8 ) );
			}
			
			response = client.execute( post );
			responseStr = IOUtils.toString( response.getEntity( ).getContent( ) );
		} catch( UnsupportedEncodingException e ){
			logger.error( Definitions.LOGGER_ERROR_2 );
		} catch( ClientProtocolException e ) {
			logger.error( Definitions.LOGGER_ERROR_3 );
		} catch( IOException e ) {
			logger.error( Definitions.LOGGER_ERROR_4 );
		} catch( Exception e ){
			logger.error( Definitions.LOGGER_ERROR_5 );
		} finally{
			if( response != null ){
				try{
					response.close( );
				} catch( Exception e ) {
					//Nothing to do
				}
			}
			if( client != null ){
				try{
					client.close( );
				} catch( Exception e ){
					//Nothing to do
				}
			}
		}
		return responseStr;
	}
	
	/**
	 * HTTP GET method
	 * 
	 * @param parameters The parameters to set in the URI
	 * @param headers Custom headers
	 * @param host Destination host
	 * @param path Destination path
	 * @return Response body as string
	 */
	public String doGet( HashMap<String, String> parameters, HashMap<String, String> headers, String protocol, String host, String path ){
		URI 					uri 		= null;
		HttpGet 				get 		= null;
		URIBuilder 				builder 	= null;
		CloseableHttpResponse 	response 	= null;
		String					responseStr	= "";
		
		try{
			builder = new URIBuilder( );
			builder.setScheme( protocol );
			builder.setHost( host );
			builder.setPath( path );
			
			if( parameters != null ){
				for( Entry<String, String> element : parameters.entrySet( ) ){
					builder.setParameter( element.getKey( ) , element.getValue( ) );
				}
			}
			
			uri = builder.build( );
			get = new HttpGet( uri );
			
			if( headers != null ){
				for( Entry<String, String> element : headers.entrySet( ) ){
					get.setHeader( element.getKey( ) , element.getValue( ) );
				}
			}
			
			response = client.execute( get );
			responseStr = IOUtils.toString( response.getEntity( ).getContent( ) );
		} catch( UnsupportedEncodingException e ){
			logger.error( Definitions.LOGGER_ERROR_2 );
		} catch( ClientProtocolException e ) {
			logger.error( Definitions.LOGGER_ERROR_3 );
		} catch( IOException e ) {
			logger.error( Definitions.LOGGER_ERROR_4 );
		} catch( Exception e ){
			logger.error( Definitions.LOGGER_ERROR_5 );
		} finally{
			if( response != null ){
				try{
					response.close( );
				} catch( Exception e ) {
					//Nothing to do
				}
			}
			if( client != null ){
				try{
					client.close( );
				} catch( Exception e ){
					//Nothing to do
				}
			}
		}
		return responseStr;
	}
	
}
