package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.shadowsatyr.bean.SystemBean;
import com.seifernet.shadowsatyr.util.Definitions;

/**
 * Helper that handle error pages
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ErrorHelper {
	
	/**
	 * Error page 404 for unknown URLs
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void error404( HttpServletRequest request, HttpServletResponse response ) {
		SystemBean bean = new SystemBean( );
		
		bean.setLayout( Definitions.ERROR_404_TILES_DEF );
		request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
	}

	/**
	 * Error page 500 for system errors
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void error500( HttpServletRequest request, HttpServletResponse response ) {
		SystemBean bean = new SystemBean( );
		
		bean.setLayout( Definitions.ERROR_500_TILES_DEF );
		request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
	}
	
	/**
	 * Error page 403 for system errors
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void error403( HttpServletRequest request, HttpServletResponse response ){
		SystemBean bean = new SystemBean( );
		
		bean.setLayout( Definitions.ERROR_403_TILES_DEF );
		request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
	}

}
