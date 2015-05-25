package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.seifernet.shadowsatyr.bean.IndexBean;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.security.SessionManager;

public class AdminHelper {

	public static void dashboard( HttpServletRequest request, HttpServletResponse response ) {
		IndexBean 	bean 	= null;
		Session		session = null;
		Subject		subject	= null;
		
		bean = new IndexBean( );
		subject = SecurityUtils.getSubject( );
		session = SessionManager.getSession( subject );
		bean.setLayout( "system.dashboard" );
		bean.setUserData( ( Account )session.getAttribute( "user_data" ) );
		request.setAttribute( "Bean", bean );
	}
	
}
