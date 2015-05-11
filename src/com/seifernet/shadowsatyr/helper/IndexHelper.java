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
import com.seifernet.snwf.bean.Bean;


public class IndexHelper {

	public static void index( HttpServletRequest request, HttpServletResponse response ) {
		IndexBean 	bean 	= null;
		Session		session = null;
		Subject		subject	= null;
		IndexFacade facade	= null;
		
		bean = new IndexBean( );
		subject = SecurityUtils.getSubject( );
		if( subject.isAuthenticated( ) ){
			session = SessionManager.getSession( subject );
			
			bean.setUserData( ( Account )session.getAttribute( "user_data" ) );
			bean.setLayout( "system.index_user" );
		} else{
			bean.setLayout( "system.index" );
		}
		
		facade = new IndexFacade( );
		bean.setLatestBlogEntries( facade.getLatestBlogEntries( ) );
		request.setAttribute( "Bean" , bean );
	}

	public static void login( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.login" );
		request.setAttribute( "Bean" , bean );
	}

}
