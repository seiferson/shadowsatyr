package com.seifernet.shadowsatyr.helper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.bean.BlogListBean;
import com.seifernet.shadowsatyr.bean.ProfileBean;
import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.engine.hashtag.HashTagProcessor;
import com.seifernet.shadowsatyr.engine.microblog.BlogManager;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;
import com.seifernet.shadowsatyr.persistance.dto.Hashtag;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.shadowsatyr.util.Definitions;
import com.seifernet.snwf.exception.ValidationException;
import com.seifernet.snwf.util.FormValidator;

/**
 * Helper for microblog operations 
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class BlogHelper {

	private static Logger logger = Logger.getLogger( BlogHelper.class );
	
	/**
	 * Method for blog entry creation
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 * @return JSON encoded text with response
	 */
	public static String createBlogEntry( HttpServletRequest request, HttpServletResponse response ) {
		Subject	subject	= SecurityUtils.getSubject( );
		
		if( subject.isAuthenticated( ) ){
			String content = request.getParameter( "blog-content" );
			
			try {
				content = FormValidator.parseParameter( content );
			} catch( ValidationException e ){
				logger.error( Definitions.LOGGER_ERROR_BLOG_CREATION );
				return Definitions.JSON_ERROR_EMPTY_MESSAGE;
			}
			
			if( FormValidator.validateParameter( content ) ){
				
				BlogEntry entry	= new BlogEntry( );
				entry.setAuthor( ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) );
				entry.setContent( content );
				entry.setDate( new Date( ) );
				
				ArrayList<String> hashtagText = HashTagProcessor.getHashTags( content );
				ArrayList<Hashtag> hashtags = new ArrayList<Hashtag>( );
				for( String hashtag: hashtagText ){
					Hashtag hs = BlogManager.getHashtag( hashtag );
					if( hs != null ){
						hashtags.add( hs );
					} else {
						hs = new Hashtag(  );
						hs.setHashtag( hashtag );
						hashtags.add( hs );
					}
				}
				
				entry.setHashtags( hashtags );
				BlogManager.createBlogEntry( entry );
			} else {
				return Definitions.JSON_ERROR_EMPTY_MESSAGE;
			}
			return Definitions.JSON_OK_RESPONSE;
		} else{
			return Definitions.JSON_ERROR_NOT_AUTHENTICATED;
		}
	}

	/**
	 * Returns the last 5 blog entries
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 * @return HTML encoded text with response
	 */
	public static String latestBlogEntries( HttpServletRequest request, HttpServletResponse response ) {
		String htmlResponse	= "";
		String template 	= null;
		
		try {
			template = IOUtils.toString( request.getServletContext( ).getResourceAsStream( "/jsp/blog_entry.jsp" ) );
		} catch( IOException e ){
			logger.error( Definitions.LOGGER_ERROR_BLOG_TEMPLATE );
			return htmlResponse;
		}
		
		ArrayList<BlogEntry> entries = BlogManager.getLatestBlogEntries( );
		for( BlogEntry entry : entries ){
			String tmp = new String( template );
			
			tmp = tmp.replace( "${entry.author.mailMD5}" , entry.getAuthor( ).getMailMD5( ) );
			tmp = tmp.replace( "${entry.author.nickname}" , entry.getAuthor( ).getNickname( ) );
			tmp = tmp.replace( "${entry.message}", entry.getContent( ) );
			
			SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy HH:mm" );
			tmp = tmp.replace( "${entry.date}" , format.format( entry.getDate( ) ) );

			htmlResponse += tmp;
		}
		
		return htmlResponse;
	}

	/**
	 * Gets all the blog entries related to specific hashtag
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void hashtag( HttpServletRequest request, HttpServletResponse response ) {
		String hashtag = request.getParameter( "hashtag" );
		
		Subject subject = SecurityUtils.getSubject( );
		BlogListBean bean = new BlogListBean( );
		
		if( subject.isAuthenticated( ) ){
			bean.setLayout( Definitions.BLOG_LIST_AUTH_TILES_DEF );
			bean.setAccount( ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) );
		} else {
			bean.setLayout( Definitions.BLOG_LIST_TILES_DEF );
		}
		
		bean.setBlogEntries( BlogManager.getBlogEntries( hashtag, 0 ) );
		request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
	}
	
}
