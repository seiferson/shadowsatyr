package com.seifernet.shadowsatyr.dispatcher;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.seifernet.firegoblin.dispatcher.ContextDispatcher;
import com.seifernet.firegoblin.servlet.ContextServlet;
import com.seifernet.shadowsatyr.helper.AccountHelper;
import com.seifernet.shadowsatyr.helper.AdminHelper;
import com.seifernet.shadowsatyr.helper.ArticleHelper;
import com.seifernet.shadowsatyr.helper.BlogHelper;
import com.seifernet.shadowsatyr.helper.ErrorHelper;
import com.seifernet.shadowsatyr.helper.IndexHelper;
import com.seifernet.shadowsatyr.util.Definitions;

/**
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class Dispatcher implements ContextDispatcher{
	
	private static final String TILES_REDIRECT_URL = "/jsp/redirect.jsp";
	
	private Logger logger = Logger.getLogger( Dispatcher.class );
	private int responseType;
	
	/**
	 * Constructor sets responseType to HTTP_RESPONSE
	 * by default
	 */
	public Dispatcher(  ){
		responseType = ContextServlet.HTTP_RESPONSE;
	}
	
	@Override
	public String dispatchAction( HttpServletRequest request, HttpServletResponse response, String action ) {
		
		try{ 
			request.setCharacterEncoding( ContextServlet.UTF8_CHARSET );
		} catch( UnsupportedEncodingException e ){
			logger.error( Definitions.LOGGER_ERROR_ENCODING );
		}
		
		switch( action ){
			case Definitions.DEFAULT_ACTION: case Definitions.INDEX:
				IndexHelper.index( request, response );
				break;
			case Definitions.LOGIN:
				IndexHelper.login( request, response );
				break;
			case Definitions.CREATE_ACCOUNT:
				responseType = ContextServlet.HTTP_REDIRECT;
				return IndexHelper.createAccount( request, response );
			case Definitions.VALIDATE_NICK_NAME:
				responseType = ContextServlet.JSON_RESPONSE;
				return IndexHelper.validateNickname( request, response );
			case Definitions.VALIDATE_MAIL:
				responseType = ContextServlet.JSON_RESPONSE;
				return IndexHelper.validateMail( request, response );
			case Definitions.PROFILE:
				AccountHelper.profile( request, response );
				break;	
			case Definitions.CREATE_BLOG_ENTRY:
				responseType = ContextServlet.JSON_RESPONSE;
				return BlogHelper.createBlogEntry( request, response );
			case Definitions.LATEST_BLOG_ENTRIES:
				responseType = ContextServlet.HTML_RESPONSE;
				return BlogHelper.latestBlogEntries( request, response );	
			case Definitions.HASHTAG:
				BlogHelper.hashtag( request, response );
				break;
			case Definitions.SAVE_ARTICLE:
				responseType = ContextServlet.HTTP_REDIRECT;
				return ArticleHelper.saveArticle( request, response );
			case Definitions.ARTICLE:
				ArticleHelper.article( request, response );
				break;
			case Definitions.CREATE_ARTICLE:
				ArticleHelper.createArticle( request, response );
				break;
			case Definitions.DASHBOARD:
				AdminHelper.dashboard( request, response );
				break;
			case Definitions.ERROR_500:
				ErrorHelper.error500( request, response );
				break;
			case Definitions.ERROR_404: default:
				ErrorHelper.error404( request, response );
		}
		
		return TILES_REDIRECT_URL;
	}

	@Override
	public int getResponseType( ) {
		return responseType;
	}

}
