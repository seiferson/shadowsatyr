package com.seifernet.shadowsatyr.helper;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.rjeschke.txtmark.Processor;
import com.seifernet.shadowsatyr.facade.ArticleFacade;
import com.seifernet.shadowsatyr.persistance.dto.Article;
import com.seifernet.snwf.bean.Bean;
import com.seifernet.snwf.exception.ValidationException;
import com.seifernet.snwf.util.FormValidator;

public class ArticleHelper {

	public static void createArticle( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.create_article" );
		request.setAttribute( "Bean" , bean );
	}
	
	public static String previewArticle( HttpServletRequest request, HttpServletResponse response ){
		String 				inText 		= null;
		String				outText		= null;
		
		if( request.getParameter( "article-content" ) != null ){
			inText = request.getParameter( "article-content" );
		}
		outText = Processor.process( inText, true );
		return outText;
	}
	
	public static void saveArticle( HttpServletRequest request, HttpServletResponse response ){
		Article 		article = null;
		String			title	= null;
		String			content	= null;
		String			author	= null;
		ArticleFacade 	facade 	= null;
		
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
				
				facade = new ArticleFacade( );
				facade.createArticle( article );
			}
		} catch( ValidationException e ){
			
		}
	}

}
