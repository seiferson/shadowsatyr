package com.seifernet.shadowsatyr.security;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.seifernet.shadowsatyr.persistance.dao.AccountDAO;
import com.seifernet.shadowsatyr.persistance.dto.Account;

public class SessionManager {

	public static Session getSession( Subject subject ) {
		Session		session 	= null;
		Account		userData 	= null;
		AccountDAO	dao			= null;
		
		session = subject.getSession( );
		if( session.getAttribute( "user_data" ) == null ){
			dao = new AccountDAO( );
			userData = dao.read( "nickname" , subject.getPrincipal( ) );
			session.setAttribute( "user_data" , userData );
		}
		
		return session;
	}
	
	
}
