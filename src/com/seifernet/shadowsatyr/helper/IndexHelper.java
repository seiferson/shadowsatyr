package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

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
		Bean 		bean = null;
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
		
		return null;
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
				return Definitions.JSON_ERROR_NOT_AVAILABLE;
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
				return Definitions.JSON_ERROR_NOT_AVAILABLE;
			}
		} catch( ValidationException e ){
			return Definitions.JSON_ERROR_EMPTY_MAIL;
		}
	}

}
