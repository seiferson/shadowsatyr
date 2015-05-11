package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.seifernet.shadowsatyr.bean.IndexBean;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.snwf.bean.Bean;


public class IndexHelper {

	public static void index( HttpServletRequest request, HttpServletResponse response ) {
		IndexBean 	bean 	= null;
		Session		session = null;
		Subject		subject	= null;
		
		subject = SecurityUtils.getSubject( );
		if( subject.isAuthenticated( ) ){
			session = SessionManager.getSession( subject );
			
			bean = new IndexBean( );
			bean.setUserData( ( Account )session.getAttribute( "user_data" ) );
			bean.setLayout( "system.index_user" );
		} else{
			bean = new IndexBean( );
			bean.setLayout( "system.index" );
		}
		request.setAttribute( "Bean" , bean );
	}

	public static void login( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.login" );
		request.setAttribute( "Bean" , bean );
	}

}
