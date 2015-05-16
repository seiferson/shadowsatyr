package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.hibernate.validator.constraints.impl.EmailValidator;

import com.seifernet.shadowsatyr.bean.IndexBean;
import com.seifernet.shadowsatyr.facade.IndexFacade;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.shadowsatyr.util.Definitions;
import com.seifernet.snwf.bean.Bean;
import com.seifernet.snwf.exception.ValidationException;
import com.seifernet.snwf.util.FormValidator;

public class IndexHelper {

	public static void index( HttpServletRequest request, HttpServletResponse response ) {
		IndexBean 	bean 	= null;
		Session		session = null;
		Subject		subject	= null;
		IndexFacade facade	= null;
		
		bean = new IndexBean( );
		subject = SecurityUtils.getSubject( );
		if( subject.isAuthenticated( ) ) {
			session = SessionManager.getSession( subject );
			
			bean.setUserData( ( Account )session.getAttribute( "user_data" ) );
			bean.setLayout( "system.index_user" );
		} else {
			bean.setLayout( "system.index" );
		}
		
		facade = new IndexFacade( );
		bean.setLatestBlogEntries( facade.getLatestBlogEntries( ) );
		request.setAttribute( "Bean" , bean );
	}

	public static void login( HttpServletRequest request, HttpServletResponse response ) {
		Bean 		bean 	= null;
		Subject		subject	= null;
		
		subject = SecurityUtils.getSubject( );
		if( subject.isAuthenticated( ) ){
			index( request, response );
		} else {
			bean = new Bean( );
			bean.setLayout( "system.login" );
			request.setAttribute( "Bean" , bean );
		}
		
	}

	public static String createUser( HttpServletRequest request, HttpServletResponse response ) {
		IndexFacade 	facade 		= null;
		Account			account 	= null;
		String			nickname 	= null;
		String			mail		= null;
		String			passwd		= null;
		String			passwdc		= null;
		EmailValidator	validator	= null;
		
		nickname = request.getParameter( "nickname" );
		mail = request.getParameter( "email" );
		passwd = request.getParameter( "passwdr" );
		passwdc = request.getParameter( "passwdcon" );
		
		facade = new IndexFacade( );
		validator = new EmailValidator( );
		
		if( facade.getAccountByMail( mail ) == null && facade.getAccountByNickname( nickname ) == null
			&& FormValidator.validateParameter( nickname ) && validator.isValid( mail , null )
			&& FormValidator.validateParameter( passwd ) && FormValidator.validateParameter( passwdc )
			&& nickname.length( ) <= 25 && mail.length( ) <= 255 && passwd.equals( passwdc )
		){
			account = new Account( );
			account.setMail( mail );
			account.setNickname( nickname );
			account.setPasswd( ( new Sha256Hash( passwd , "", 5342 ) ).toString( ) );
			
			facade.createAccount( account );
			return Definitions.URL_ACCOUNT_CREATED;
		}
		
		return Definitions.URL_ACCOUNT_CREATION_ERROR;
	}

	public static String validateNickname( HttpServletRequest request, HttpServletResponse response ) {
		String 		nickname 	= null;
		IndexFacade facade		= null;
		
		try{
			nickname = FormValidator.parseParameter( request.getParameter( "nickname" ) );
			
			if( FormValidator.validateParameter( nickname ) ){
				facade = new IndexFacade( );
				if( facade.getAccountByNickname( nickname ) != null ){
					return Definitions.JSON_ERROR_NOT_AVAILABLE;
				} else {
					return Definitions.JSON_OK_RESPONSE;
				}
			} else{
				return Definitions.JSON_ERROR_EMPTY_NICKNAME;
			}
		} catch( ValidationException e ){
			return Definitions.JSON_ERROR_EMPTY_NICKNAME;
		}
	}

	public static String validateMail( HttpServletRequest request, HttpServletResponse response ) {
		String 		mail	 	= null;
		IndexFacade facade		= null;
		
		try{
			mail = FormValidator.parseParameter( request.getParameter( "email" ) );
			
			if( FormValidator.validateParameter( mail ) ){
				facade = new IndexFacade( );
				if( facade.getAccountByMail( mail ) != null ){
					return Definitions.JSON_ERROR_NOT_AVAILABLE;
				} else {
					return Definitions.JSON_OK_RESPONSE;
				}
			} else{
				return Definitions.JSON_ERROR_EMPTY_MAIL;
			}
		} catch( ValidationException e ){
			return Definitions.JSON_ERROR_EMPTY_MAIL;
		}
	}

}
