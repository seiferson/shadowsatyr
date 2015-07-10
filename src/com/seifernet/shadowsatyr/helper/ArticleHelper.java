package com.seifernet.shadowsatyr.helper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.shadowsatyr.persistance.dto.Article;
import com.seifernet.snwf.bean.Bean;
import com.seifernet.snwf.exception.ValidationException;

import com.seifernet.snwf.util.FormValidator;

/**
 * 
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ArticleHelper {

	/**
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void createArticle( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean =  new Bean( );
		
		bean.setLayout( "system.create_article" );
		request.setAttribute( "Bean" , bean );
	}
	
	/**
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void saveArticle( HttpServletRequest request, HttpServletResponse response ){
		Article 		article = null;
		String			title	= null;
		String			content	= null;
		String			author	= null;
		
		try{
			title = FormValidator.parseParameter( request.getParameter( "article-title" ) );
			content = FormValidator.parseParameter( request.getParameter( "article-content" ) );
			author = FormValidator.parseParameter( request.getParameter( "article-author" ) );
			
			if( FormValidator.validateParameter( title ) && FormValidator.validateParameter( content ) &&
				FormValidator.validateParameter( author )
			){
				article = new Article( );
				article.setCreationDate( new Date( ) );
				article.setTitle( title );
				article.setContent( content );
				article.setAuthor( author );
				
			}
		} catch( ValidationException e ){
			
		}
	}

}
