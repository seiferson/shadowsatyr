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
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class Dispatcher implements ContextDispatcher{
	
	private Logger logger = Logger.getLogger( Dispatcher.class );
	private int responseType;
	
	private static final String TILES_REDIRECT_URL 	= "/jsp/redirect.jsp";
	
	private static final String DEFAULT_ACTION 		= "/";
	private static final String INDEX 				= "/index";
	private static final String LOGIN 				= "/login";
	private static final String CREATE_ACCOUNT		= "/createaccount";
	private static final String VALIDATE_NICK_NAME 	= "/validatenickname";
	private static final String VALIDATE_MAIL	 	= "/validatemail";
	private static final String ERROR_500			= "/error500";
	private static final String ERROR_404			= "/error404";
	private static final String PROFILE				= "/profile";
	private static final String LATEST_BLOG_ENTRIES = "/latestblogentries";
	private static final String HASHTAG				= "/hashtag";
	private static final String ARTICLE				= "/article";
	private static final String CREATE_BLOG_ENTRY 	= "/user/createblogentry";
	private static final String DASHBOARD 			= "/user/dashboard";
	private static final String CREATE_ARTICLE 		= "/user/createarticle";
	private static final String SAVE_ARTICLE 		= "/user/savearticle";
	private static final String MARKDOWN_PARSER		= "/markdownparser";
	
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
			case DEFAULT_ACTION: case INDEX:
				IndexHelper.index( request, response );
				break;
			case LOGIN:
				IndexHelper.login( request, response );
				break;
			case CREATE_ACCOUNT:
				responseType = ContextServlet.HTTP_REDIRECT;
				return IndexHelper.createAccount( request, response );
			case VALIDATE_NICK_NAME:
				responseType = ContextServlet.JSON_RESPONSE;
				return IndexHelper.validateNickname( request, response );
			case VALIDATE_MAIL:
				responseType = ContextServlet.JSON_RESPONSE;
				return IndexHelper.validateMail( request, response );
			case PROFILE:
				AccountHelper.profile( request, response );
				break;	
			case CREATE_BLOG_ENTRY:
				responseType = ContextServlet.JSON_RESPONSE;
				return BlogHelper.createBlogEntry( request, response );
			case LATEST_BLOG_ENTRIES:
				responseType = ContextServlet.HTML_RESPONSE;
				return BlogHelper.latestBlogEntries( request, response );	
			case HASHTAG:
				BlogHelper.hashtag( request, response );
				break;
			case SAVE_ARTICLE:
				responseType = ContextServlet.HTTP_REDIRECT;
				return ArticleHelper.saveArticle( request, response );
			case ARTICLE:
				ArticleHelper.article( request, response );
				break;
			case CREATE_ARTICLE:
				ArticleHelper.createArticle( request, response );
				break;
			case DASHBOARD:
				AdminHelper.dashboard( request, response );
				break;
			case MARKDOWN_PARSER:
				responseType = ContextServlet.HTML_RESPONSE;
				return ArticleHelper.markdownParser( request, response );
			case ERROR_500:
				ErrorHelper.error500( request, response );
				break;
			case ERROR_404: default:
				ErrorHelper.error404( request, response );
		}
		
		return TILES_REDIRECT_URL;
	}

	@Override
	public int getResponseType( ) {
		return responseType;
	}

}
