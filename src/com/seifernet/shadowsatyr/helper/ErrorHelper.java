package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.snwf.bean.Bean;

public class ErrorHelper {

	public static void error404( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.error404" );
		request.setAttribute( "Bean" , bean );
	}

	public static void error500( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.error500" );
		request.setAttribute( "Bean" , bean );
	}

}
