package com.seifernet.shadowsatyr.util;

import org.jboss.logging.Logger;

/**
 * Validation for form parameters
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.3.5
 * @since 1.3.5
 */
public class FormValidator {
	
	private static Logger logger = Logger.getLogger( FormValidator.class );
	
	/**
	 * Method to prevent HTML and Javascript injection.
	 * 
	 * @param parameter Parameter to parse
	 * @return Parsed an cleaned parameter
	 * @throws ValidationException
	 */
	public static String parseParameter( String parameter ) throws Exception{
		if( parameter == null ){
			logger.error( "Attribute to validate is null" );
			throw new Exception( "Attribute to validate is null" );
		}
		return parameter.trim( ).replace( "<" , "&lt;" ).replace( ">" , "&gt;" );
	}
	
	/**
	 * Method to validate non empty parameters
	 * 
	 * @param parameter Parameter to validate
	 * @return True if parameter is not empty, false otherwise
	 */
	public static boolean validateParameter( String parameter ){
		if( parameter == null || parameter.trim( ).equals( "" ) ){
			return false;
		}
		else{
			return true;
		}
	}
}
