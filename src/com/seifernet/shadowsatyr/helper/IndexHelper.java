package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.shadowsatyr.persistance.dao.ArticleDAO;
import com.seifernet.snwf.bean.Bean;

public class IndexHelper {

	public static void index( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.index" );
		request.setAttribute( "Bean" , bean );
		new ArticleDAO( ).read( 1L );
	}

	public static void login( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.login" );
		request.setAttribute( "Bean" , bean );
	}

}
