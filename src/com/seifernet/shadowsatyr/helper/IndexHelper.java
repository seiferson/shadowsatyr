package com.seifernet.shadowsatyr.helper;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.hibernate.validator.constraints.impl.EmailValidator;
import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.bean.IndexBean;
import com.seifernet.shadowsatyr.bean.SystemBean;
import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.engine.microblog.BlogManager;
import com.seifernet.shadowsatyr.persistence.dto.Account;
import com.seifernet.shadowsatyr.persistence.dto.Permission;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.shadowsatyr.util.Definitions;
import com.seifernet.shadowsatyr.util.FormValidator;

/**
 * Helper for welcome page, login and register pages
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class IndexHelper {

	private Logger logger = Logger.getLogger( IndexHelper.class );
	
	/**
	 * Method to show welcome page
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void index( HttpServletRequest request, HttpServletResponse response ) {
		Subject		subject	= SecurityUtils.getSubject( );
		IndexBean 	bean 	= new IndexBean( );
		
		if( subject.isAuthenticated( ) ) {
			Account account = ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME );
			bean.setAccount( account );
			bean.setLayout( Definitions.INDEX_USER_TILES_DEF );
		} else {
			bean.setLayout( Definitions.INDEX_TILES_DEF );
		}
		
		bean.setLatestBlogEntries( BlogManager.getLatestBlogEntries( ) );
		request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
	}

	/**
	 * Show login screen
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void login( HttpServletRequest request, HttpServletResponse response ) {
		Subject	subject	= SecurityUtils.getSubject( );
		
		//If subject is authenticated is redirected to home page
		if( subject.isAuthenticated( ) ){
			index( request, response );
		} else {
			SystemBean bean = new SystemBean( );
			bean.setLayout( Definitions.LOGIN_TILES_DEF );
			request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
		}
	}
	
	/**
	 * Registers an account on the system
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 * @return URL redirecting to login indicating if account was created or not
	 */
	public static String createAccount( HttpServletRequest request, HttpServletResponse response ) {
		Subject	subject	= SecurityUtils.getSubject( );
		
		//There's no reason to create an account if you are already authenticated
		if( subject.isAuthenticated( ) ){
			return Definitions.INDEX_URL;
		} else {
			String nickname = request.getParameter( "nickname" );
			String mail = request.getParameter( "email" );
			String passwd = request.getParameter( "passwdr" );
			String passwdc = request.getParameter( "passwdcon" );
			
			EmailValidator validator = new EmailValidator( );
			if( AccountManager.getAccountByMail( mail ) == null && AccountManager.getAccountByNickname( nickname ) == null
					&& FormValidator.validateParameter( nickname ) && validator.isValid( mail , null )
					&& FormValidator.validateParameter( passwd ) && FormValidator.validateParameter( passwdc )
					&& nickname.length( ) <= 25 && mail.length( ) <= 255 && passwd.equals( passwdc )
				){
				
				Account	account = new Account( );
				account.setMail( mail );
				account.setNickname( nickname );
				account.setPasswd( ( new Sha256Hash( passwd , "", 5342 ) ).toString( ) );
				account.setStatus( AccountManager.ACTIVE_ACCOUNT_STATUS );
				account.setRegisterDate( new Date( ) );
				
				ArrayList<Permission> permissionList = new ArrayList<Permission>( );
				Permission permission = new Permission( );
				permission.setId( Definitions.SYSTEM_TEST_PERMISSION_ID );
				permissionList.add( permission );
				
				account.setPermissions( permissionList );
				
				AccountManager.createAccount( account );
				return Definitions.ACCOUNT_CREATED_URL;
			} else {
				return Definitions.ACCOUNT_CREATION_ERROR_URL;
			}
		}
	}

	/**
	 * Validates if nickname already exist in the database
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 * @return JSON encoded text with response
	 */
	public static String validateNickname( HttpServletRequest request, HttpServletResponse response ) {
		
		try{
			String nickname = FormValidator.parseParameter( request.getParameter( "nickname" ) );
			
			if( FormValidator.validateParameter( nickname ) ){
				if( AccountManager.getAccountByNickname( nickname ) != null ){
					return Definitions.JSON_ERROR_NOT_AVAILABLE;
				} else {
					return Definitions.JSON_OK_RESPONSE;
				}
			} else{
				return Definitions.JSON_ERROR_EMPTY_NICKNAME;
			}
		} catch( Exception e ){
			return Definitions.JSON_ERROR_EMPTY_NICKNAME;
		}
	}

	/**
	 * Validates if mail already exist in the database
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 * @return JSON encoded text with response
	 */
	public static String validateMail( HttpServletRequest request, HttpServletResponse response ) {
		
		try{
			String mail = FormValidator.parseParameter( request.getParameter( "email" ) );
			
			if( FormValidator.validateParameter( mail ) ){
				if( AccountManager.getAccountByMail( mail ) != null ){
					return Definitions.JSON_ERROR_NOT_AVAILABLE;
				} else {
					return Definitions.JSON_OK_RESPONSE;
				}
			} else{
				return Definitions.JSON_ERROR_EMPTY_MAIL;
			}
		} catch( Exception e ){
			return Definitions.JSON_ERROR_EMPTY_MAIL;
		}
	}

}
