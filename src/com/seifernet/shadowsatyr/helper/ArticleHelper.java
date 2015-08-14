package com.seifernet.shadowsatyr.helper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.bean.ArticleBean;
import com.seifernet.shadowsatyr.bean.SystemBean;
import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.engine.article.ArticleManager;
import com.seifernet.shadowsatyr.engine.markdown.MarkdownProcessor;
import com.seifernet.shadowsatyr.persistence.dto.Account;
import com.seifernet.shadowsatyr.persistence.dto.Article;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.shadowsatyr.util.Definitions;
import com.seifernet.shadowsatyr.util.FormValidator;

/**
 * Helper for article publishing tasks
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class ArticleHelper {

	private static Logger logger = Logger.getLogger( ArticleHelper.class );
	
	/**
	 * Show the article creation form
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void createArticle( HttpServletRequest request, HttpServletResponse response ) {
		SystemBean 	bean 	= new SystemBean( );
		Subject 	subject = SecurityUtils.getSubject( );
		
		bean.setLayout( Definitions.CREATE_ARTICLE_TILES_DEF );
		bean.setAccount( ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) );
		request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
	}
	
	/**
	 * Save an article to the database
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static String saveArticle( HttpServletRequest request, HttpServletResponse response ){
		Subject subject = SecurityUtils.getSubject( );
		
		if( subject.isAuthenticated( ) ){
			try{ 
				String title = FormValidator.parseParameter( request.getParameter( "article-title" ) );
				String content = FormValidator.parseParameter( request.getParameter( "article-content" ) );
			
				if( FormValidator.validateParameter( title ) && FormValidator.validateParameter( content ) ){
					
					Article article = new Article( );
					article.setCreationDate( new Date( ) );
					article.setTitle( title );
					article.setContent( content );
					article.setAuthor( ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) );
					article.setHashKey( ( new Sha256Hash( title , "", 256 ) ).toString( ) );
					
					ArticleManager.createArticle( article );
					return Definitions.ARTICLE_URL + "?article=" + article.getHashKey( );
				} else {
					logger.error( Definitions.LOGGER_ERROR_PARAM_VALIDATION );
					return Definitions.ERROR_500_URL;
				}
			} catch( Exception e ){
				logger.error( Definitions.LOGGER_ERROR_PARAM_VALIDATION );
				return Definitions.ERROR_500_URL;
			}
		} else {
			logger.error( Definitions.LOGGER_ERROR_UNAUTHORIZED );
			return Definitions.ERROR_403_URL;
		}
	}
	
	/**
	 * 
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void article( HttpServletRequest request, HttpServletResponse response ){
		String hash = request.getParameter( "article" );
		
		if( !FormValidator.validateParameter( hash ) || ArticleManager.getArticleByHash( hash ) == null ){
			logger.error( Definitions.LOGGER_ERROR_ARTICLE );
			ErrorHelper.error404( request, response );
		} else {
			Subject subject = SecurityUtils.getSubject( );
			ArticleBean bean = new ArticleBean( );
			
			if( subject.isAuthenticated( ) ){
				bean.setLayout( Definitions.ARTICLE_AUTH_TILES_DEF );
			} else {
				bean.setLayout( Definitions.ARTICLE_TILES_DEF );
			}
			
			bean.setArticle( ArticleManager.getArticleByHash( hash ) );
			bean.setAccount( ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) );
			request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
		}
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public static String markdownParser( HttpServletRequest request, HttpServletResponse response ) {
		String text = request.getParameter( "data" );
		if( text != null ){
			return MarkdownProcessor.toMarkdown( text );
		}
		return "";
	}

}
