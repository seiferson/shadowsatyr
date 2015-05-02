package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.snwf.bean.Bean;

public class ArticleHelper {

	public static void createArticle( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.create_article" );
		request.setAttribute( "Bean" , bean );
	}

}
